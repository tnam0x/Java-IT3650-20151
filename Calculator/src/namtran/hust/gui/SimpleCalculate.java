package namtran.hust.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Font;

public class SimpleCalculate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField resultJText;
	private JPanel motherPanel;
	private double tempNumbers1 = 0;
	private double tempNumbers2 = 0;
	private byte function = -1;
	private boolean recentEnter, recentFunction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SimpleCalculate();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalculate(){
		// create main frame
		setTitle("Calculator");
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			try {
				UIManager.setLookAndFeel(new NimbusLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				System.out.println(e.getMessage());
			}
		setSize(230, 330);
		setResizable(false);
		setLocationByPlatform(true);
		setVisible(true);

		// create number buttons
		JButton[] numberButtons = new JButton[10];
		for (int i = 9; i >= 0; i--)
			numberButtons[i] = new JButton(Integer.toString(i));

		JButton enterButton = new JButton("Enter");
		enterButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton cButton = new JButton("C");
		cButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton signalButton = new JButton("+/-");
		signalButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton commaButton = new JButton(".");
		commaButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton multiplyButton = new JButton("x");
		multiplyButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton divideButton = new JButton("/");
		divideButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton addButton = new JButton("+");
		addButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JButton substractButton = new JButton("-");
		substractButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

		// create text field to display
		resultJText = new JTextField("0");
		resultJText.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		resultJText.setBounds(22, 11, 180, 25);
		resultJText.setPreferredSize(new Dimension(180, 25));
		resultJText.setBackground(Color.WHITE);
		resultJText.setEnabled(false);
		resultJText.setHorizontalAlignment(JTextField.RIGHT);
		resultJText.setDisabledTextColor(Color.RED);
		resultJText.setBorder(BorderFactory.createLoweredBevelBorder());

		// mother panel
		motherPanel = new JPanel();

		// text panel
		JPanel textPanel = new JPanel();
		textPanel.setBounds(0, 0, 224, 52);
		textPanel.setPreferredSize(new Dimension(0, 0));
		textPanel.setLayout(null);
		textPanel.add(resultJText);

		// number button panel
		JPanel numberButtonsPanel = new JPanel();
		numberButtonsPanel.setBounds(0, 52, 224, 122);
		numberButtonsPanel.setPreferredSize(new Dimension(160, 70));
		for (int i = 9; i >= 0; i--)
			numberButtonsPanel.add(numberButtons[i]);
		numberButtonsPanel.add(commaButton);
		numberButtonsPanel.add(signalButton);

		// calculation panel
		JPanel calculationButtonPanel = new JPanel();
		calculationButtonPanel.setBounds(0, 174, 224, 43);
		calculationButtonPanel.setPreferredSize(new Dimension());
		calculationButtonPanel.add(multiplyButton);
		calculationButtonPanel.add(divideButton);
		calculationButtonPanel.add(addButton);
		calculationButtonPanel.add(substractButton);

		// function panel
		JPanel functionButtonPanel = new JPanel();
		functionButtonPanel.setBounds(0, 216, 224, 62);
		functionButtonPanel.setPreferredSize(new Dimension());
		functionButtonPanel.add(enterButton);
		functionButtonPanel.add(cButton);

		// add event
		NumberButtonsAction[] numberButtonActions = new NumberButtonsAction[10];
		for (int i = 9; i >= 0; i--) {
			numberButtonActions[i] = new NumberButtonsAction(numberButtons[i]);
			numberButtons[i].addActionListener(numberButtonActions[i]);
		}

		signalButton.addActionListener(new SignalButton());
		commaButton.addActionListener(new CommaButton());
		enterButton.addActionListener(new EnterButton());
		cButton.addActionListener(new CButton());
		multiplyButton.addActionListener(new MultiplyButton());
		divideButton.addActionListener(new DivideButton());
		addButton.addActionListener(new AddButton());
		substractButton.addActionListener(new SubstractButton());

		// create menu
		JMenuBar menuBar;
		JMenu menuAbout, menuFile;
		JMenuItem itemExit;

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 230, 21);

		menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe Script", Font.PLAIN, 12));
		menuFile.setMnemonic(KeyEvent.VK_F);
		itemExit = new JMenuItem("Exit", KeyEvent.VK_E);
		itemExit.setFont(new Font("Segoe Script", Font.PLAIN, 12));
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == itemExit)
					System.exit(0);
			}
		});
		menuFile.add(itemExit);

		menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe Script", Font.PLAIN, 12));
		menuAbout.setMnemonic(KeyEvent.VK_A);
		menuAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(motherPanel,
						"Designed by Trần Xuân Nam\nCopyright © 1995, 2015 Oracle and/or its affiliates. All rights reserved.",
						"About author", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// add menu to menu panel
		menuBar.add(menuFile);
		menuBar.add(menuAbout);

		// add to mother panel
		this.setJMenuBar(menuBar);
		motherPanel.setLayout(null);
		motherPanel.add(textPanel);
		motherPanel.add(numberButtonsPanel);
		motherPanel.add(calculationButtonPanel);
		motherPanel.add(functionButtonPanel);
		setContentPane(motherPanel);
	}

	/**
	 * create the event
	 */
	private class NumberButtonsAction implements ActionListener {
		String c;

		public NumberButtonsAction(JButton a) {
			this.c = a.getText();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// clear all
			if (recentEnter) {
				resultJText.setText("0");
				tempNumbers1 = 0;
				tempNumbers1 = 0;
				function = -1;
				recentEnter = false;
			}

			if ((!resultJText.getText().equals("0")) && !recentEnter)
				resultJText.setText(resultJText.getText() + c);
			else {
				resultJText.setText(c);
				// actionPerformed(e);
			}
		}
	}

	private class SignalButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String c = resultJText.getText();
			if (c.equals("0") || c.isEmpty() || c.equals("0.0"))
				resultJText.setText("-");
			else if (c.charAt(0) == '-') {
				c = c.substring(1, c.length());
				resultJText.setText(c);
			} else
				resultJText.setText("-" + c);
		}
	}

	private class CommaButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String c = resultJText.getText();
			boolean key = true;
			for (int i = 0; i < c.length(); i++)
				if (c.charAt(i) == '.') {
					key = false;
					break;
				}
			if (key) {
				if (c.equals("0") || c.isEmpty())
					resultJText.setText("0.");
				else
					resultJText.setText(c + ".");
			}
		}
	}

	private class EnterButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty() && !resultJText.getText().equals("-")) {
				calculate();
				recentEnter = true;
				recentFunction = false;
			} else {
				JOptionPane.showMessageDialog(motherPanel, "Please enter a number!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class CButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resultJText.setText("0");
			tempNumbers1 = 0;
			tempNumbers1 = 0;
			function = -1;
			recentEnter = false;
			recentFunction = false;
		}
	}

	private class MultiplyButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 0;
		}
	}

	private class DivideButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 1;
		}
	}

	private class AddButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 2;
		}
	}

	private class SubstractButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!resultJText.getText().isEmpty()) {
				if (recentFunction)
					calculate();
				if (tempNumbers1 == 0 || recentEnter) {
					tempNumbers1 = Double.parseDouble(resultJText.getText());
					resultJText.setText("");
					recentEnter = false;
				} else {
					resultJText.setText("");
				}
				recentFunction = true;
			}
			function = 3;
		}
	}

	/**
	 * calculate
	 */
	public void calculate() {
		tempNumbers2 = Double.parseDouble(resultJText.getText());
		if (function == 0)
			resultJText.setText(Double.toString(tempNumbers1 * tempNumbers2));
		else if (function == 1)
			resultJText.setText(Double.toString((tempNumbers1) / tempNumbers2));
		else if (function == 2)
			resultJText.setText(Double.toString(tempNumbers1 + tempNumbers2));
		else if (function == 3)
			resultJText.setText(Double.toString(tempNumbers1 - tempNumbers2));
		else
			resultJText.setText(String.valueOf(tempNumbers2));
		tempNumbers1 = Double.parseDouble(resultJText.getText());
		tempNumbers2 = 0;
	}
}
