package namtran.hust.applets;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawLines extends Applet{
	private static final long serialVersionUID = 1L;
	int[] x = {50,80,200,400};
	int[] y = {30,120,270,350};
	public String getAppletInfo() {
		return "Create by Trần Xuân Nam";
	}
	
	public void paint(Graphics g) {
		setSize(new Dimension(450, 400));
		g.setColor(Color.ORANGE);
		g.fillRect(1, 1, 450, 400);
	}
}
