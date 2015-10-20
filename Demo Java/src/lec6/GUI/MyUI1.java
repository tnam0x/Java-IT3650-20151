package lec6.GUI;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyUI1 extends JFrame {
	private static final long serialVersionUID = 1L;

	public MyUI1(String title) {
		setTitle("My JFrame");
		doAddSomeControl();
	}

	public void doAddSomeControl() {
		JPanel pn = new JPanel();
		JButton btn1 = new JButton("Hello I’m JFrame");
		JTextField txt1 = new JTextField(15);

		pn.add(btn1);
		pn.add(txt1);

		Container con = getContentPane();
		con.add(pn);
		setSize(300, 200);
		setLocationRelativeTo(null);
	}
}
