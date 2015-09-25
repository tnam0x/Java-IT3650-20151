package namtran.hust.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class SpeciesTank extends FishTank {
	private final String NAME = "Species Tank";
	private final int QUOTA = 20;
	private float salinitiesTank;
	private String temperatureTank;
	private float phTank;
	private Fish fish;
	private int iFish;
	private static Scanner sc;
	private ArrayList<Fish> listFish = new ArrayList<Fish>();

	public SpeciesTank() {
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
			System.out.println("Invalid!");

		// độ pH
		System.out.print("Enter pH of tank (1-14): ");
		sc = new Scanner(System.in);
		phTank = sc.nextFloat();
		System.out.println("Created!");
	}

	@Override
	public void display() {
		System.out.println(NAME);
		if (listFish.isEmpty())
			System.out.println("\tNo any fish in this tank!");
		else
			for (int i = 0; i < listFish.size(); i++)
				System.out.println("\t" + listFish.get(i));
	}

	@Override
	public boolean checkFishSuitability(Fish fish) {
		boolean result = false;
		if (this.listFish.isEmpty())
			result = true;
		else if (0 < this.listFish.size() && this.listFish.size() < QUOTA)
			if (this.listFish.get(0).getSpeciesName().equalsIgnoreCase(fish.getSpeciesName()))
				if (fish.checkEnviroment(phTank, salinitiesTank, temperatureTank))
					result = true;
		if (!result)
			System.out.println("Can't add fish in tank!");
		return result;
	}

	@Override
	public void addFish(Fish fish) {
		this.listFish.add(fish);
	}

	@Override
	public void removeFish(String name) {
		boolean key = false;
		for (int i = 0; i < listFish.size(); i++)
			if (name.equalsIgnoreCase(listFish.get(i).getSpeciesName())) {
				listFish.remove(i);
				key = true;
				break;
			}
		if (!key)
			System.out.println("No species fish like that!");
	}

	@Override
	public Fish getFishToMove() {
		fish = listFish.get(iFish);
		return fish;
	}

	@Override
	public boolean checkFishInTank(String name) {
		boolean result = false;
		for (int i = 0; i < listFish.size(); i++) {
			if (name.equalsIgnoreCase(listFish.get(i).getSpeciesName())) {
				result = true;
				iFish = i;
				break;
			}
		}
		if (!result)
			System.out.println("'" + name + "'" + " don't have in tank!");
		return result;
	}

	@Override
	public String getNAME() {
		return NAME;
	}
}
