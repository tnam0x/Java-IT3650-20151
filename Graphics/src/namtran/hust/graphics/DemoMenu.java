package namtran.hust.graphics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class DemoMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane tpName;
	private JRadioButton itemRed, itemOrange, itemGreen;
	private JRadioButton itemThor, itemOdin, itemZeus;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoMenu frame = new DemoMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DemoMenu() {
		setTitle("Demo");
		setResizable(false);
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.LIGHT_GRAY);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 220, 20);
		contentPane.add(menuBar);

		JMenu colorMenu = new JMenu("Colors");
		colorMenu.setForeground(Color.RED);
		menuBar.add(colorMenu);

		itemRed = new JRadioButton("Red");
		itemRed.addActionListener(new menuAction());
		colorMenu.add(itemRed);

		itemOrange = new JRadioButton("Orange");
		itemOrange.addActionListener(new menuAction());
		colorMenu.add(itemOrange);

		itemGreen = new JRadioButton("Green");
		itemGreen.addActionListener(new menuAction());
		colorMenu.add(itemGreen);

		JMenu nameMenu = new JMenu("Names");
		nameMenu.setForeground(Color.RED);
		menuBar.add(nameMenu);

		itemThor = new JRadioButton("Thor");
		itemThor.addActionListener(new menuAction());
		nameMenu.add(itemThor);

		itemOdin = new JRadioButton("Odin");
		itemOdin.addActionListener(new menuAction());
		nameMenu.add(itemOdin);

		itemZeus = new JRadioButton("Zeus");
		itemZeus.addActionListener(new menuAction());
		nameMenu.add(itemZeus);

		tpName = new JTextPane();
		tpName.setEnabled(false);
		tpName.setDisabledTextColor(Color.BLACK);
		tpName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		tpName.setBounds(25, 32, 146, 26);
		tpName.setText("Don't selected a name yet");
		tpName.setBackground(contentPane.getBackground());
		contentPane.add(tpName);
	}

	private class menuAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object menuClicked = e.getSource();
			// color
			if (menuClicked == itemRed) {
				contentPane.setBackground(Color.RED);
				itemOrange.setSelected(false);
				itemGreen.setSelected(false);
			}
			else if (menuClicked == itemOrange) {
				contentPane.setBackground(Color.ORANGE);
				itemRed.setSelected(false);
				itemGreen.setSelected(false);
			}
			else if (menuClicked == itemGreen) {
				contentPane.setBackground(Color.GREEN);
				itemRed.setSelected(false);
				itemOrange.setSelected(false);
			}

			// name
			else if (menuClicked == itemThor) {
				tpName.setText("Name has choose: Thor");
				itemOdin.setSelected(false);
				itemZeus.setSelected(false);
			} else if (menuClicked == itemOdin) {
				tpName.setText("Name has choose: Odin");
				itemThor.setSelected(false);
				itemZeus.setSelected(false);
			} else {
				tpName.setText("Name has choose: Zeus");
				itemThor.setSelected(false);
				itemOdin.setSelected(false);
			}
			tpName.setBackground(contentPane.getBackground());
		}
	}
}
