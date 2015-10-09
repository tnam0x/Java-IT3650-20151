package namtran.hust.gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SimpleCalculate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton button_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_2;
	private JButton btnNewButton_6;
	private JButton button;
	private JButton btnNewButton_5;
	private JButton btnNewButton_7;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SimpleCalculate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalculate() {
		setTitle("Calculate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 97, 21);
		contentPane.add(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnFile);

		JMenu mnExit = new JMenu("Exit");
		mnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(mnExit);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		textField = new JTextField();
		textField.setBounds(0, 32, 293, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JCheckBox radioButton = new JCheckBox("+");
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		radioButton.setBounds(241, 59, 33, 23);
		contentPane.add(radioButton);

		JCheckBox radioButton_1 = new JCheckBox("-");
		radioButton_1.setBounds(241, 85, 33, 23);
		contentPane.add(radioButton_1);

		JCheckBox rdbtnX = new JCheckBox("x");
		rdbtnX.setBounds(241, 111, 33, 23);
		contentPane.add(rdbtnX);

		JCheckBox radioButton_2 = new JCheckBox("/");
		radioButton_2.setBounds(241, 136, 33, 23);
		contentPane.add(radioButton_2);

		JPanel panel = new JPanel();
		panel.setBounds(27, 77, 208, 173);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 5, 5, 5));

		JButton btnNewButton_3 = new JButton("1");
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new EventHandler());

		button_1 = new JButton("2");
		panel.add(button_1);

		btnNewButton = new JButton("3");
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("4");
		panel.add(btnNewButton_1);

		btnNewButton_4 = new JButton("5");
		panel.add(btnNewButton_4);

		btnNewButton_2 = new JButton("6");
		panel.add(btnNewButton_2);

		btnNewButton_6 = new JButton("7");
		panel.add(btnNewButton_6);

		button = new JButton("8");
		panel.add(button);

		btnNewButton_5 = new JButton("9");
		panel.add(btnNewButton_5);

		btnNewButton_7 = new JButton("0");
		panel.add(btnNewButton_7);

		button_2 = new JButton("=");
		button_2.setBounds(241, 173, 42, 23);
		contentPane.add(button_2);
		setVisible(true);
	}

	private class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String lblButton = e.getActionCommand();
			if(lblButton.equals(1))
				textField.setText("1");
		}

	}

}
