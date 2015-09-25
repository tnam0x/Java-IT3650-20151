package lec4.OOP;

import java.util.Random;

public class Die {
	private int face;

	public Die() {
		this.face = 1;
	}

	public int roll() {
		Random rand = new Random();
		this.face = rand.nextInt(6) + 1;
		return face;
	}

	public int getFace() {
		return face;
	}
}
