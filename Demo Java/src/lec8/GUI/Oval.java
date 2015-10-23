package lec8.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Oval extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	Timer timer = new Timer(5, this);

    public static void main(String[] args) {
        new Oval();
    }
    static int x = 300;
    static int y = 200;
    static int velx;
    static int vely;

    public Oval() {
        timer.start();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(138, 222, 208));
        g.fillRect(100, 75, 600, 450);
        g.setColor(Color.red);
        g.fillOval(x, y, 50, 50);
    }

    public void actionPerformed(ActionEvent e) {

        if (x < 100 || x > 645) {
            velx = -velx;
        }
        if (y < 75 || y > 475) {
            vely = -vely;
        }
        x += velx;
        y += vely;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            vely = -10;
            velx = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            vely = 10;
            velx = 0;
        }
        if (key == KeyEvent.VK_LEFT) {
            vely = 0;
            velx = -10;
        }
        if (key == KeyEvent.VK_RIGHT) {
            vely = 0;
            velx = 10;
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
