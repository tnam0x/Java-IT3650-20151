package namtran.hust.applets;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class DrawShapes extends JApplet {
	private static final long serialVersionUID = 1L;
	int x = 300, y = 100, r = 50;
	
	@Override
	public void paint(Graphics g) {
		setSize(400, 400);
		g.setColor(Color.orange);
		g.fillRect(1, 1, 450, 400);
		
		g.setColor(Color.RED);
		g.drawRect(50, 50, 300, 150);
		g.setColor(Color.RED);
		g.drawOval(50, 50, 300, 150);
		g.setColor(Color.RED);
		g.drawLine(50, 50, 250, 100);
		showStatus(getAppletInfo());
	}

	@Override
	public String getAppletInfo() {
		return "Created by Trần Xuân Nam";
	}
}
