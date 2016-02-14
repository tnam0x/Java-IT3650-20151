package hust.namtran;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FireWorks extends JFrame {
	private static final long serialVersionUID = 1L;

	public FireWorks(String... a) {
		setTitle("JFrameAnimation");
		ImageIcon img = getImage(
				"https://49.media.tumblr.com/0e55c47a20589f85ae85f7cfa4376971/tumblr_n9672yRBhf1t5c6u6o1_500.gif");
		int mode = (a.length == 1) ? Integer.parseInt(a[0]) : 2;
		if (mode > 2 || mode < 0)
			mode = 2;
		if (mode == 0) {// Method 1
			setLayout(new BorderLayout());
			JLabel jl = new JLabel(img);
			jl.setLayout(new FlowLayout());
			add(jl);
		} else if (mode == 1) { // Method 2
			setLayout(new BorderLayout());
			setContentPane(new JLabel(img));
			setLayout(new FlowLayout());
		} else { // Method 3
			add(new JLabel(img));
		}
		setBackground(Color.black);
		setSize(img.getIconWidth() + 250, img.getIconHeight() + 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private ImageIcon getImage(String pic) {
		if (pic.indexOf("://") < 0 && (new File(pic)).exists())
			return new ImageIcon(pic);
		else
			try {
				return new ImageIcon(new URL(pic));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	public static void main(String... a) {
		new FireWorks(a);
	}
}
