package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Timer clock;
	private JTextField txtTimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super("Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(10, 26, 89, 23);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(10, 60, 89, 23);
		contentPane.add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(10, 94, 89, 23);
		contentPane.add(btnReset);

		btnStart.addActionListener(new ButtonActionListener());
		btnStop.addActionListener(new ButtonActionListener());
		btnReset.addActionListener(new ButtonActionListener());

		txtTimer = new JTextField();
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setText("Never started");
		txtTimer.setBounds(116, 27, 86, 20);
		txtTimer.setEditable(false);
		contentPane.add(txtTimer);

		clock = new Timer(100, new MyTimerActionListener());

	}

	public void paint(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.drawOval(150, 100, 150, 150);
	}

	private class MyTimerActionListener implements ActionListener {
		double time = 0.0D;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			time += clock.getDelay();
			txtTimer.setText(time / 1000 + "");
		}
	}

	private class ButtonActionListener implements ActionListener {
		String s;
		boolean recentReset = false;

		@Override
		public void actionPerformed(ActionEvent e) {
			s = e.getActionCommand();
			if (s.equals("Start")) {
				if (recentReset)
					clock.restart();
				else
					clock.start();
			} else if (s.equals("Stop")) {
				clock.stop();
			} else {
				clock.stop();
				txtTimer.setText("0.0");
				recentReset = true;
			}
		}
	}
}
