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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import namtran.hust.guis.controller.DisplayProductController;
import namtran.hust.guis.controller.Run;
import namtran.hust.guis.controller.SignInController;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static String url;
	private JFileChooser fileChooser = new JFileChooser();

	public MainWindow() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println(e.getMessage());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(400, 200, 600, 400);
		setTitle("Smart Store");
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// mother panel
		JPanel motherPanel = new JPanel();
		motherPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.setBounds(10, 11, 564, 339);
		contentPane.add(motherPanel);
		motherPanel.setLayout(null);

		// create menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(3, 3, 558, 43);
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

		JMenuItem itemCreatNewAccount = new JMenuItem("Create new account");
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

		ImageIcon icon = new ImageIcon("src\\iconOpen.png");
		JButton btnChooseDataFile = new JButton("Choose data file...", icon);
		btnChooseDataFile.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnChooseDataFile.setBounds(30, 289, 175, 39);
		// btnChooseDataFile.setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));
		motherPanel.add(btnChooseDataFile);

		// add event
		itemChooseDataFile.addActionListener(new EventHandler());
		btnChooseDataFile.addActionListener(new EventHandler());
		itemSignOut.addActionListener(new EventHandler());
		itemCreatNewAccount.addActionListener(new EventHandler());
		itemAbout.addActionListener(new EventHandler());
		itemExit.addActionListener(new EventHandler());

		// create table
		table = new JTable(new DisplayProductController(url));
		table.setFillsViewportHeight(true);
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
		if (select == JFileChooser.APPROVE_OPTION) {
			File dataFile = fileChooser.getSelectedFile();
			url = dataFile.getAbsolutePath();
			setVisible(false);
			Run run = new Run();
			run.updateTable();
		}
	}

	// event handler
	private class EventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();

			// menu about
			if (s.equals("About"))
				JOptionPane.showMessageDialog(contentPane,
						"Designed by Trần Xuân Nam\nCopyright ©2015\n(c) Copyright Eclipse contributors and others 2000, 2015.  All rights reserved.",
						"About author", JOptionPane.INFORMATION_MESSAGE);

			// menu exit
			else if (s.equals("Exit"))
				System.exit(0);

			// menu choose data file...
			else if (s.equals("Choose data file..."))
				openFile();

			// menu sign out
			else if (s.equals("Sign out")) {
				Run run = new Run();
				run.signOutHandler();
			}

			// menu create
			else if (s.equals("Create new account")) {
				SignInController sic = new SignInController();
				if (sic.getCurrentAccountPermission() != 1) {
					JOptionPane.showMessageDialog(MainWindow.this,
							"You don't have permission, please login with administrator account!", "Invalid",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else
					new CreateNewAccountForm().setVisible(true);
			}
		}
	}
}
