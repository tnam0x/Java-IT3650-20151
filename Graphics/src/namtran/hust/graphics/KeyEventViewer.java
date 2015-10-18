package namtran.hust.graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class KeyEventViewer extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	public static void main(String[] args) {
		KeyEventViewer myWindow = new KeyEventViewer();
		myWindow.setVisible(true);
	}

	public KeyEventViewer() {
		setSize(WIDTH, HEIGHT);
		setLocation(150, 150);

		this.addWindowListener(new WindowCloser());
		this.addKeyListener(new KeyHandler());
	}

	private class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			System.out.println("KEY EVENT: " + arg0.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			System.out.println("KEY EVENT: " + arg0.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			System.out.println("KEY EVENT: " + arg0.getKeyCode());
		}

	}

}
