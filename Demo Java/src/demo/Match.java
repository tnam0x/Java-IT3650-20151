package demo;

import java.util.Scanner;

public class Match {
	private Die die;
	private Player player1;
	private Player player2;
	private Player winner;
	private int rounds;
	private static Scanner sc;

	public Match(String namePlayer1, String namePlayer2) {
		this.player1 = new Player(namePlayer1);
		this.player2 = new Player(namePlayer2);
		this.rounds = 0;
		this.die = new Die();
	}
	
	public void runMatch() {
		start();
		stop();
	}

	public void start() {
		System.out.println("--->Start game".toUpperCase());
		System.out.print("Enter rounds: ");
		sc = new Scanner(System.in);
		this.rounds = sc.nextInt();
		for (int i = 0; i < this.rounds; i++) {
			System.out.println("--->ROUND " + (i + 1)+"<---");
			System.out.println(player1.getName().toUpperCase() + " throw!");
			player1.throwDie(die);
			System.out.println(player2.getName().toUpperCase() + " throw!");
			player2.throwDie(die);
		}
	}

	public void stop() {
		System.out.println("--->Stop game".toUpperCase());
		player1.displayInfo();
		player2.displayInfo();
		if (player1.getPoint() > player2.getPoint()) {
			this.winner = player1;
			System.out.println("The winner is " + winner.getName());
		} else if (player1.getPoint() < player2.getPoint()) {
			this.winner = player2;
			System.out.println("The winner is " + winner.getName());
		}
	}
}
