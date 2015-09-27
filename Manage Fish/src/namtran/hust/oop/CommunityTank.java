package namtran.hust.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunityTank extends FishTank {
	private final String NAME = "Community Tank";
	private String sizeTank;
	private int quota;
	private float salinitiesTank;
	private String temperatureTank;
	private float phTank;
	private static Scanner sc;
	private Fish fish;
	private int iFish;
	private ArrayList<Fish> listFish = new ArrayList<Fish>();

	public CommunityTank(String sizeTank) {
		this.sizeTank = sizeTank;

		// quota
		if ("small tank".equalsIgnoreCase(sizeTank))
			this.quota = 10;
		else if ("medium tank".equalsIgnoreCase(sizeTank))
			this.quota = 40;
		else if ("big tank".equalsIgnoreCase(sizeTank))
			this.quota = 80;

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
		System.out.println(NAME + " - " + sizeTank);
		if (listFish.isEmpty())
			System.out.println("\tNo any fish in this tank!");
		else
			for (int i = 0; i < listFish.size(); i++) {
				System.out.println("\t" + listFish.get(i));
			}
	}

	public boolean checkFishSuitability(Fish fish) {
		boolean result = false;
		if (fish.isFeature())
			if (this.listFish.size() < quota)
				if (fish.checkEnviroment(phTank, salinitiesTank, temperatureTank))
					result = true;
		if (!result)
			System.out.println("Can't add fish in tank!");
		return result;
	}

	public void addFish(Fish fish) {
		this.listFish.add(fish);
	}

	public void removeFish(String name) {
		for (int i = 0; i < listFish.size(); i++)
			if (name.equalsIgnoreCase(listFish.get(i).getSpeciesName())) {
				listFish.remove(i);
				break;
			}
	}

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

	public Fish getFishToMove() {
		fish = listFish.get(iFish);
		return fish;
	}

	public String getNAME() {
		return NAME + " - " + sizeTank;
	}
}
