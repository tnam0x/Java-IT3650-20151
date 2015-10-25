package namtran.hust.guis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;

import namtran.hust.guis.model.ProductList;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
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
		mnProduct.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnProduct);

		JMenuItem itemChooseDataFile = new JMenuItem("Choose data file");
		itemChooseDataFile.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnProduct.add(itemChooseDataFile);

		JMenu mnAccount = new JMenu("Account");
		mnAccount.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnAccount);

		JMenuItem itemSignOut = new JMenuItem("Sign out");
		itemSignOut.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnAccount.add(itemSignOut);

		JMenuItem itemCreatNewAccount = new JMenuItem("Creat new account");
		itemCreatNewAccount.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnAccount.add(itemCreatNewAccount);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Arial Black", Font.PLAIN, 15));
		menuBar.add(mnHelp);

		JMenuItem itemtmAbout = new JMenuItem("About");
		itemtmAbout.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnHelp.add(itemtmAbout);

		JMenuItem itemExit = new JMenuItem("Exit");
		itemExit.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mnHelp.add(itemExit);

		// create data table
		ProductTable productTable = new ProductTable();
		table = new JTable(productTable);
		table.setFont(new Font("Consolas", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 65, 524, 206);
		motherPanel.add(scrollPane);
	}

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
}
