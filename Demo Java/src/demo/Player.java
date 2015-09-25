package demo;

import java.util.Scanner;

public class Player {
	private String name;
	private int point;
	private static Scanner sc;

	public Player(String name) {
		this.name = name;
		this.point = 0;
	}

	public void throwDie(Die die) {
		int currentThrow;
		System.out.print("Press Enter to throw Die...");
		sc = new Scanner(System.in);
		sc.nextLine();
		currentThrow = die.roll();
		this.point += currentThrow;
		System.out.println(currentThrow + " points");
	}

	public void displayInfo() {
		System.out.println(this.name + " have " + this.point + " points");
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}
}
