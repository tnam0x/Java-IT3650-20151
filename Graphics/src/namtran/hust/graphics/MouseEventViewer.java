package namtran.hust.graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MouseEventViewer extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	public static void main(String[] args) {
		MouseEventViewer myWindow = new MouseEventViewer();
		myWindow.setVisible(true);
	}

	public MouseEventViewer() {
		setSize(WIDTH, HEIGHT);
		setLocation(150, 150);

		this.addWindowListener(new WindowCloser());
		this.addMouseListener(new MouseHandler());
	}

	private class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	private class MouseHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Clicked");
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Dragged");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Entered");
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Exited");
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Moved");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Released");
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent arg0) {
			System.out.println("MOUSE EVENT: Mouse Wheel Moved");
		}

		public void mousePressed(MouseEvent e) {
			System.out.println("MOUSE EVENT: Mouse Pressed");
		}

	}
}
