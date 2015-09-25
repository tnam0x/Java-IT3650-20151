package namtran.hust.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class SpeciesTank extends FishTank {
	private final String NAME = "Species Tank";
	private final int QUOTA = 20;
	private float salinitiesTank;
	private String temperatureTank;
	private float phTank;
	private static Scanner sc;
	private ArrayList<Fish> listFish = new ArrayList<Fish>();

	/**
	 * @param salinitiesTank
	 * @param temperatureTank
	 * @param phTank
	 */
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
	}

	@Override
	public void display() {
		if (listFish.isEmpty())
			System.out.println("No any fish in this tank!");
		else
			for (int i = 0; i < listFish.size(); i++)
				System.out.println(listFish.get(i));
	}

	@Override
	public boolean checkFishSuitability(Fish fish) {
		boolean result = false;
		if (this.listFish.size() == 0)
			result = true;
		else if (this.listFish.get(0).getSpeciesName().equalsIgnoreCase(fish.getSpeciesName()))
			if (fish.checkEnviroment(phTank, salinitiesTank, temperatureTank))
				result = true;
		if (!result)
			System.out.println("Can't add fish in tank!");
		return result;
	}

	@Override
	public void addFish(Fish fish) {
		if (this.listFish.size() < QUOTA) {
			this.listFish.add(fish);
			System.out.println("Added!");
		} else
			System.out.println("Reached quota!");
	}

	@Override
	public void removeFish(String name) {
		for (int i = 0; i < listFish.size(); i++)
			if (name.equalsIgnoreCase(listFish.get(i).getSpeciesName())) {
				listFish.remove(i);
				System.out.println("Removed!");
				break;
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

	public int getQUOTA() {
		return QUOTA;
	}

	@Override
	public String getNAME() {
		return NAME;
	}
}
