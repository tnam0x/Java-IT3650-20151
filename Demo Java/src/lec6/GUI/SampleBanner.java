package lec6.GUI;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class SampleBanner extends Applet implements Runnable {
	private static final long serialVersionUID = -3938815916804158680L;
	String str = "This is a simple Banner ";
	Thread t;
	boolean b;

	public void init() {
		setBackground(Color.BLUE);
		setForeground(Color.yellow);
	}

	public void start() {
		t = new Thread(this);
		b = false;
		t.start();
	}

	@Override
	public void run() {
		char ch;
		for (;;) {
			try {
				repaint();
				Thread.sleep(100);
				ch = str.charAt(0);
				str = str.substring(1, str.length());
				str = str + ch;
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void paint(Graphics g) {
		g.drawRect(1, 1, 300, 150);
		g.setColor(Color.yellow);
		g.fillRect(1, 1, 300, 150);
		g.setColor(Color.red);
		g.drawString(str, 1, 150);
	}
}
