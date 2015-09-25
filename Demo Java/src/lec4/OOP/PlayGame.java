package lec4.OOP;

import java.util.Scanner;

public class PlayGame {
	private static Scanner nhap;

	public static void main(String[] args) {
		Match match;
		String playerName1, playerName2;
		int rounds;

		nhap = new Scanner(System.in);
		System.out.print("Enter the name of the 1st player: ");
		playerName1 = nhap.nextLine();
		System.out.print("Enter the name of the 2nd player: ");
		playerName2 = nhap.nextLine();
		System.out.print("Enter the number of rounds: ");
		rounds = nhap.nextInt();

		match = new Match(playerName1, playerName2, rounds);
		match.runMatch();
	}
}
