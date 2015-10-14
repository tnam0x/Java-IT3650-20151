package namtran.hust.applets;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawCircle extends Applet {
	private static final long serialVersionUID = 1L;

	@Override
	public String getAppletInfo() {
		return "Create by Trần Xuân Nam";
	}

	@Override
	public void paint(Graphics g) {
		setSize(new Dimension(400, 400));
		g.setColor(Color.ORANGE);
		g.fillRect(1, 1, 400, 400);
		
		g.setColor(Color.MAGENTA);
		g.fillArc(50, 50, 300, 300, 0, 90);
		
		g.setColor(Color.GREEN);
		g.fillArc(50, 50, 300, 300, 90, 90);
		
		g.setColor(Color.PINK);
		g.fillArc(50, 50, 300, 300, 180, 90);
		
		g.setColor(Color.GRAY);
		g.fillArc(50, 50, 300, 300, 270, 90);
	}

}
