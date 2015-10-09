package lec6.GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Countdown extends Frame {
	private static final long serialVersionUID = 4590584563433169064L;
	private TextField tfCount;
	private Button btnCountUp, btnCountDown, btnReset;
	private int count = 0;

	public Countdown() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));

		tfCount = new TextField("0", 10);
		add(tfCount);
		tfCount.setEnabled(false);

		btnCountUp = new Button("Count up");
		add(btnCountUp);

		btnCountDown = new Button("Count down");
		add(btnCountDown);

		btnReset = new Button("Reset");
		add(btnReset);

		BtnActionListener listener = new BtnActionListener();
		btnCountUp.addActionListener(listener);
		btnCountDown.addActionListener(listener);
		btnReset.addActionListener(listener);
		setTitle("AWT Count");
		setSize(400, 100);
		setLocationRelativeTo(null); // center
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Countdown();
	}

	private class BtnActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String btnLabel = e.getActionCommand();
			if (btnLabel.equals("Count up"))
				count++;
			else if (btnLabel.equals("Count down"))
				count--;
			else if (btnLabel.equals("Reset"))
				count = 0;
			tfCount.setText(count + "");
		}
	}
}
