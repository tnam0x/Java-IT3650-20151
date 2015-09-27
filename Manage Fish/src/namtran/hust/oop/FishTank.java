package namtran.hust.oop;

public abstract class FishTank {
	public FishTank() {
	}

	public abstract void display();

	public abstract boolean checkFishSuitability(Fish fish);

	public abstract void addFish(Fish fish);

	public abstract void removeFish(String name);

	public abstract boolean checkFishInTank(String name);
	
	public abstract Fish getFishToMove();

	public abstract String getNAME();
}
