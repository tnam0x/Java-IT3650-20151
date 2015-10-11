package namtran.hust.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SimpleCalculate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField resultJText;
	private double tempNumbers1 = 0;
	private double tempNumbers2 = 0;
	private byte function = -1;
	private boolean beforeEnter;

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
		setSize(200, 280);
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		JButton[] numberButtons = new JButton[10];
		for (int i = 9; i >= 0; i--)
			numberButtons[i] = new JButton(Integer.toString(i));

		JButton enterButton = new JButton("Enter");
		JButton cButton = new JButton("C");
		JButton multiplyButton = new JButton("*");
		JButton divideButton = new JButton("/");
		JButton addButton = new JButton("+");
		JButton substractButton = new JButton("-");

		resultJText = new JTextField("0");
		resultJText.setPreferredSize(new Dimension(180, 25));
		resultJText.setBackground(Color.WHITE);
		resultJText.setEnabled(false);
		resultJText.setHorizontalAlignment(4);
		resultJText.setDisabledTextColor(Color.RED);
		resultJText.setBorder(BorderFactory.createLoweredBevelBorder());

		JPanel motherPanel = new JPanel();
		motherPanel.setLayout(new BoxLayout(motherPanel, BoxLayout.Y_AXIS));

		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension());
		textPanel.add(resultJText);

		JPanel numberButtonsPanel = new JPanel();
		numberButtonsPanel.setPreferredSize(new Dimension(160, 80));
		for (int i = 9; i >= 0; i--)
			numberButtonsPanel.add(numberButtons[i]);

		JPanel calculationButtonPanel = new JPanel();
		calculationButtonPanel.setPreferredSize(new Dimension());
		calculationButtonPanel.add(multiplyButton);
		calculationButtonPanel.add(divideButton);
		calculationButtonPanel.add(addButton);
		calculationButtonPanel.add(substractButton);
		
		JPanel functionButtonPanel = new JPanel();
		functionButtonPanel.setPreferredSize(new Dimension());
		functionButtonPanel.add(enterButton);
		functionButtonPanel.add(cButton);
		
		NumberButtonsAction[] numberButtonActions = new NumberButtonsAction[10];
		for(int i=9; i>=0; i--) {
			numberButtonActions[i] = new NumberButtonsAction(numberButtons[i]);
			numberButtons[i].addActionListener(numberButtonActions[i]);
		}
		
		enterButton.addActionListener(new EnterButton());
		cButton.addActionListener(new CButton());
		multiplyButton.addActionListener(new MultiplyButton());
		divideButton.addActionListener(new DivideButton());
		addButton.addActionListener(new AddButton());
		substractButton.addActionListener(new SubstractButton());

		motherPanel.add(textPanel);
		motherPanel.add(numberButtonsPanel);
		motherPanel.add(calculationButtonPanel);
		motherPanel.add(functionButtonPanel);
		add(motherPanel);
	}

	private class NumberButtonsAction implements ActionListener {
		String c;
		public NumberButtonsAction(JButton a) {
			this.c = a.getText();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(beforeEnter){
				resultJText.setText("0");
				tempNumbers1 = 0;
				tempNumbers1 = 0;
				function = -1;
				beforeEnter = false;
			}
				
			if ((!resultJText.getText().equals("0")) && (!resultJText.getText().equals("0.0")))
				resultJText.setText(resultJText.getText() + c);
			else {
				resultJText.setText(c);
				//actionPerformed(e);
			}
		}
	}

	private class EnterButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tempNumbers2 = Double.parseDouble(resultJText.getText());
			if (function == 0)
				resultJText.setText(Double.toString(tempNumbers1 * tempNumbers2));
			else if (function == 1)
				resultJText.setText(Double.toString(Math.round(tempNumbers1) / tempNumbers2));
			else if (function == 2)
				resultJText.setText(Double.toString(tempNumbers1 + tempNumbers2));
			else if (function == 3)
				resultJText.setText(Double.toString(tempNumbers1 - tempNumbers2));
			else
				 resultJText.setText(String.valueOf(tempNumbers2));
			tempNumbers1 = Double.parseDouble(resultJText.getText());
			beforeEnter = true;
		}
	}

	private class CButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resultJText.setText("0");
			tempNumbers1 = 0;
			tempNumbers1 = 0;
			function = -1;
		}
	}

	private class MultiplyButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tempNumbers1 == 0) {
				tempNumbers1 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			} else {
				tempNumbers2 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			}
			function = 0;
		}
	}

	private class DivideButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tempNumbers1 == 0) {
				tempNumbers1 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			} else {
				tempNumbers2 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			}
			function = 1;
		}
	}

	private class AddButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tempNumbers1 == 0) {
				tempNumbers1 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			} else {
				tempNumbers2 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			}
			function = 2;
		}
	}

	private class SubstractButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tempNumbers1 == 0) {
				tempNumbers1 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			} else {
				tempNumbers2 = Double.parseDouble(resultJText.getText());
				resultJText.setText("");
			}
			function = 3;
		}
	}
}
