package namtran.hust.guis.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import namtran.hust.guis.model.ProductList;

public class MainWindow extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JFileChooser fileChooser = new JFileChooser();
	private String url;
	private static MainWindow mainWindow;
	private static Thread t2;

	public static void main(String[] args) {
		t2 = new Thread(new MainWindow());
		t2.start();
	}


	@Override
	public void run() {
		mainWindow = new MainWindow();
		setVisible(true);
	}
	
	public MainWindow() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setTitle("Smart Store");
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel motherPanel = new JPanel();
		motherPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.setBounds(10, 11, 564, 339);
		contentPane.add(motherPanel);
		motherPanel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 534, 43);
		motherPanel.add(menuBar);

		JMenu mnProduct = new JMenu("Product");
		mnProduct.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(mnProduct);

		JMenuItem itemChooseDataFile = new JMenuItem("Choose data file...");
		itemChooseDataFile.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		mnProduct.add(itemChooseDataFile);

		JMenu mnAccount = new JMenu("Account");
		mnAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(mnAccount);

		JMenuItem itemSignOut = new JMenuItem("Sign out");
		itemSignOut.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		mnAccount.add(itemSignOut);

		JMenuItem itemCreatNewAccount = new JMenuItem("Creat new account");
		itemCreatNewAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		mnAccount.add(itemCreatNewAccount);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(mnHelp);

		JMenuItem itemAbout = new JMenuItem("About");
		itemAbout.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		mnHelp.add(itemAbout);

		JMenuItem itemExit = new JMenuItem("Exit");
		itemExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		mnHelp.add(itemExit);
		
		ImageIcon icon = new ImageIcon("iconOpen.png");
		JButton btnChooseDataFile = new JButton("Choose data file...",icon);
		btnChooseDataFile.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnChooseDataFile.setBounds(30, 289, 164, 39);
		btnChooseDataFile.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.add(btnChooseDataFile);
		
		// add event
		itemChooseDataFile.addActionListener(new EventHandler());
		btnChooseDataFile.addActionListener(new EventHandler());
		itemSignOut.addActionListener(new EventHandler());
		itemCreatNewAccount.addActionListener(new EventHandler());
		itemAbout.addActionListener(new EventHandler());
		itemExit.addActionListener(new EventHandler());

		// create table
		ProductTable productTable = new ProductTable();
		table = new JTable(productTable);
		table.setFont(new Font("Consolas", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 65, 524, 206);
		motherPanel.add(scrollPane);
	}
	
	// handler when open a file
	public void openFile() {
		FileFilter fileFilter = new FileNameExtensionFilter("Text File (*.txt)", "txt");
		fileChooser.setFileFilter(fileFilter);
		fileChooser.setMultiSelectionEnabled(false);
		
		int select = fileChooser.showOpenDialog(this);
		if(select == JFileChooser.APPROVE_OPTION) {
			File dataFile = fileChooser.getSelectedFile();
			url = dataFile.getAbsolutePath();
		}
	}

	// table handler
	private class ProductTable extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private ProductList proList = new ProductList();
		private final int NUMBERS_OF_ROW = proList.getProduct().size();
		private final String[] columnNames = { "Product ID", "Product name", "Amount" };
		private Object[][] data = new Object[NUMBERS_OF_ROW][3];

		public ProductTable() {
			for (int i = 0; i < NUMBERS_OF_ROW; i++) {
				data[i][0] = proList.getProduct().get(i).getProductID();
				data[i][1] = proList.getProduct().get(i).getProductName();
				data[i][2] = proList.getProduct().get(i).getAmount();
			}
		}

		@Override
		public int getColumnCount() {
			return data[0].length;
		}

		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}
	}
	
	// event handler
	private class EventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("About"))
				JOptionPane.showMessageDialog(contentPane, "Designed by Trần Xuân Nam\nCopyright ©2015", "About author", JOptionPane.INFORMATION_MESSAGE);
			else if(s.equals("Exit"))
				System.exit(0);
			else if(s.equals("Choose data file..."))
				openFile();
			else if(s.equals("Sign out")) {
				t2.interrupt();
			}
		}
	}
}
