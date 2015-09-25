package lec4.OOP;

import java.io.IOException;
import java.util.Scanner;

public class Player {
	private String playerName;
	private int point;
	private int wonMatch;
	private Scanner pressKey;

	public Player(String playerName) {
		this.playerName = playerName;
		this.point = 0;
		this.wonMatch = 0;
	}

	public void throwDie(Die die) {
		int currentThrow;
		pressKey = new Scanner(System.in);
		System.out.print("Press Enter to throw your Dice!");

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pressKey.nextLine();

		currentThrow = die.roll();
		this.point += currentThrow;
		System.out.println(currentThrow + " points");
	}

	public String getName() {
		return playerName;
	}

	public int getWonMatch() {
		return wonMatch;
	}

	public void setWonMatch() {
		++this.wonMatch;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
