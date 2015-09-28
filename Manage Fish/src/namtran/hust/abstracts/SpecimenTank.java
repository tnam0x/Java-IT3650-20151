package namtran.hust.abstracts;

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
		System.out.println("Created!");
	}

	public void display() {
		System.out.println(NAME);
		if (fish == null)
			System.out.println("\tNo fish in this tank!");
		else
			System.out.println("\t" + fish);
	}

	public boolean checkFishSuitability(Fish fish) {
		if (this.fish == null)
			if (fish.checkEnviroment(phTank, salinitiesTank, temperatureTank))
				return true;
			else {
				System.out.println("Can't add fish in tank!");
				return false;
			}
		else {
			System.out.println("Full tank, can't add!");
			return false;
		}
	}

	public void addFish(Fish fish) {
		this.fish = fish;
	}

	public void removeFish(String name) {
		boolean key = false;
		if (fish.getSpeciesName().equalsIgnoreCase(name)) {
			fish = null;
			key = true;
		}
		if (!key)
			System.out.println("No species fish like that!");
	}

	public Fish getFishToMove() {
		return fish;
	}

	public boolean checkFishInTank(String name) {
		if (fish.getSpeciesName().equalsIgnoreCase(name))
			return true;
		else {
			System.out.println("'" + name + "'" + " don't have in tank!");
			return false;
		}
	}

	public String getNAME() {
		return NAME;
	}
}
