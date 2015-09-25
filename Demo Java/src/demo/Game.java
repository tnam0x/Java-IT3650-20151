package demo;

import java.util.Scanner;

public class Game {
	static Scanner sc;

	public static void main(String[] args) {
		String playerName1, playerName2;
		sc = new Scanner(System.in);
		System.out.print("Enter the name of the 1st player: ");
		playerName1 = sc.nextLine();
		System.out.print("Enter the name of the 2nd player: ");
		playerName2 = sc.nextLine();
		Match match = new Match(playerName1, playerName2);
		match.runMatch();
	}
}
