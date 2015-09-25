package namtran.hust.oop;

import java.util.Scanner;

public class SpecimenTank extends FishTank {
	private final String NAME = "Specimen Tank";
	private float salinitiesTank;
	private String temperatureTank;
	private float phTank;
	private Fish fish;
	private static Scanner sc;

	public SpecimenTank() {
		// nồng độ muối
		System.out.print("Enter salinities(%): ");
		sc = new Scanner(System.in);
		salinitiesTank = sc.nextFloat();

		// nhiệt độ
		System.out.print("Enter temperature ([N]hiệt đới/[H]àn đới): ");
		sc = new Scanner(System.in);
		String chooseTemp = sc.nextLine();
		if ("n".equalsIgnoreCase(chooseTemp))
			temperatureTank = "Nhiệt Đới";
		else if ("h".equalsIgnoreCase(chooseTemp))
			temperatureTank = "Hàn Đới";
		else
			System.out.println("Không hợp lệ!");

		// độ pH
		System.out.print("Enter pH of tank (1-14): ");
		sc = new Scanner(System.in);
		phTank = sc.nextFloat();
	}

	@Override
	public void display() {
		if (fish == null)
			System.out.println("No fish in this tank!");
		else
			System.out.println(fish);
	}

	@Override
	public boolean checkFishSuitability(Fish fish) {
		boolean result = false;
		if (fish == null)
			result = true;
		if (!result)
			System.out.println("Full tank!");
		return result;
	}

	@Override
	public void addFish(Fish fish) {
		this.fish = fish;
		System.out.println("Added!");
	}

	@Override
	public void removeFish(String name) {
		if (fish.getSpeciesName().equalsIgnoreCase(name)) {
			fish = null;
			System.out.println("Removed!");
		}
	}

	public float getSalinitiesTank() {
		return salinitiesTank;
	}

	public String getTemperatureTank() {
		return temperatureTank;
	}

	public float getPhTank() {
		return phTank;
	}

	@Override
	public String getNAME() {
		return NAME;
	}
}
