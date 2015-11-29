package lec9.Thread;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Demo extends JFrame {
	private static final long serialVersionUID = 1L;
	private HighThread high;
	private LowThread low;
	private JTextArea output;

	public Demo() {
		super("Demo");
		output = new JTextArea(10, 20);
		add(output);
		setSize(250, 200);
		setVisible(true);

		high = new HighThread(output);
		high.start();

		low = new LowThread(output);
		low.start();
	}

	public static void main(String args[]) {
		Demo app = new Demo();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class HighThread extends Thread {
	private JTextArea display;

	public HighThread(JTextArea jTxtArea) {
		display = jTxtArea;
		setPriority(Thread.MAX_PRIORITY);
	}

	public void run() {
		for (int x = 1; x <= 5; x++) {
			try {
				sleep((int) (Math.random() * 1000));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(), "Exception", JOptionPane.ERROR_MESSAGE);
			}
			display.append("High Priority Thread\n");
		}

	}
}

class LowThread extends Thread {
	private JTextArea display;

	public LowThread(JTextArea jTxtArea) {
		display = jTxtArea;
		setPriority(Thread.MIN_PRIORITY);
	}

	public void run() {
		for (int y = 1; y <= 5; y++)
			display.append("Low Priority Thread\n");
	}
}
