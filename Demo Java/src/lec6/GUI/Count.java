package lec6.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Count extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*new Count();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Count();
			}
		});*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Count();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Count() {
		//super("Swing Counter");
		setTitle("Swing Counter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblCounter = new JLabel("Counter");
		lblCounter.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		lblCounter.setBounds(33, 47, 46, 31);
		contentPane.add(lblCounter);

		textField = new JTextField("0", 10);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(89, 44, 102, 34);
		contentPane.add(textField);
		textField.setEnabled(false);

		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count++;
				textField.setText(count + "");
			}
		});
		btnUp.setBounds(239, 43, 89, 23);
		contentPane.add(btnUp);

		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count--;
				textField.setText(count + "");
			}
		});
		btnDown.setBounds(239, 77, 89, 23);
		contentPane.add(btnDown);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count = 0;
				textField.setText(count + "");
			}
		});
		btnReset.setBounds(239, 111, 89, 23);
		contentPane.add(btnReset);
	}
}
