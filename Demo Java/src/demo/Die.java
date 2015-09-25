package demo;

public class Die {
	private int face;

	public Die() {
		this.face = 0;
	}

	public int roll() {
		this.face = (int) (Math.random() * 6 + 1);
		return this.face;
	}

	public int getFace() {
		return face;
	}
}
