package lec4.OOP;

public class Match {
	private Die die;
	private Player player1;
	private Player player2;
	private Player winner;
	private int rounds;

	public Match(String playerName1, String playerName2, int rounds) {
		this.player1 = new Player(playerName1);
		this.player2 = new Player(playerName2);
		this.die = new Die();
		this.rounds = rounds;
	}

	public void runMatch() {
		start();
		stop();
		displayInfo();
	}

	public void start() {
		System.out.println("-->Start game!");
		for (int j = 1; j <= 3; j++) {
			for (int i = 1; i <= rounds; i++) {
				System.out.println("-----Round " + i + "-Game " + j + "-----");
				System.out.println(player1.getName() + " throw!");
				player1.throwDie(die);
				System.out.println(player2.getName() + " throw!");
				player2.throwDie(die);
			}
			check();
			if (player1.getWonMatch() == 2 || player2.getWonMatch() == 2)
				break;
		}
	}

	public void check() {
		if (player1.getPoint() > player2.getPoint()) {
			this.winner = player1;
			player1.setWonMatch();
		} else if (player1.getPoint() < player2.getPoint()) {
			this.winner = player2;
			player2.setWonMatch();
		}
	}

	public void stop() {
		System.out.println("-->Stop game!");
		if (player1.getWonMatch() > player2.getWonMatch())
			this.winner = player1;
		else if (player1.getWonMatch() < player2.getWonMatch())
			this.winner = player2;
	}

	public void displayInfo() {
		System.out.println("-----Result-----");
		System.out.println(player1.getName() + " has " + player1.getPoint() + " points");
		System.out.println(player2.getName() + " has " + player2.getPoint() + " points");
		if (this.winner != null)
			System.out.println("The winner is " + winner.getName() + " in " + winner.getWonMatch() + " games");
		else
			System.out.println("You are draw");
	}
}
