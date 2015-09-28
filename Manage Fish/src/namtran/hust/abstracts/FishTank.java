package namtran.hust.abstracts;

import java.util.InputMismatchException;

public abstract class FishTank {
	public FishTank() throws InputMismatchException{
	}

	public abstract void display();

	public abstract boolean checkFishSuitability(Fish fish);

	public abstract void addFish(Fish fish);

	public abstract void removeFish(String name);

	public abstract boolean checkFishInTank(String name);
	
	public abstract Fish getFishToMove();

	public abstract String getNAME();
}
