package namtran.assignment1;

import java.util.Scanner;

public class Student {
	private String name;
	private int id;
	private int score;
	private static Scanner nhap;

	public String getName() {
		return name;
	}

	public void setName() {
		nhap = new Scanner(System.in);
		System.out.print("\tEnter name: ");
		this.name = nhap.nextLine();
	}

	public int getId() {
		return id;
	}

	public void setId() {
		nhap = new Scanner(System.in);
		System.out.print("\tEnter id: ");
		this.id = nhap.nextInt();
	}

	public int getScore() {
		return score;
	}

	public void setScore() {
		nhap = new Scanner(System.in);
		System.out.print("\tEnter score: ");
		this.score = nhap.nextInt();
	}
}
