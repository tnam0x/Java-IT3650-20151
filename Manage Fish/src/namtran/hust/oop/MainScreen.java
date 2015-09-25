package namtran.hust.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class MainScreen {
	private static final int NUMBER_OF_TANK = 25;
	private static ArrayList<FishTank> listTank = new ArrayList<FishTank>();
	private static Scanner sc;
	private CommunityTank communityTank;
	private SpeciesTank speciesTank;
	private SpecimenTank specimenTank;
	private Fish fish;

	public static void main(String[] args) {
		MainScreen ms = new MainScreen();
		// begin
		while (true) {
			System.out.println("*-----Menu-----*".toUpperCase());
			System.out.println("a. Thêm một bể cá");
			System.out.println("b. Thêm 1 con cá vào bể");
			System.out.println("c. Bỏ một con cá khỏi bể");
			System.out.println("d. Chuyển 1 con cá giữa 2 bể");
			System.out.println("e. Hiển thị cá trong tất cả các bể");
			System.out.println("f. Thoát");
			System.out.print("Choose an option: ");
			sc = new Scanner(System.in);
			String choose = sc.nextLine();
			if (choose.equalsIgnoreCase("a"))
				ms.createTank();
			else if (choose.equalsIgnoreCase("b"))
				ms.addFishInTank();
			else if (choose.equalsIgnoreCase("c"))
				ms.removeFishOutTank();
			else if (choose.equalsIgnoreCase("d"))
				ms.moveFishInOtherTank();
			else if (choose.equalsIgnoreCase("e"))
				ms.displayFishInTank();
			else if (choose.equalsIgnoreCase("f"))
				break;
			else
				System.out.println("Wrong, try again!");
		}
	}

	// create tank
	public void createTank() {
		System.out.println("*-----Create Tank-----*".toUpperCase());
		if (listTank.size() >= NUMBER_OF_TANK)
			System.out.println("Số lượng bể đã đạt tối đã, không thể thêm!");
		else {
			System.out.println("1. Community Tank");
			System.out.println("2. Species Tank");
			System.out.println("3. Specimen Tank");
			System.out.print("Choose a type of tank: ");
			sc = new Scanner(System.in);
			int chooseTank = sc.nextInt();

			// create Community Tank
			if (chooseTank == 1)
				while (true) {
					System.out.println("1. Small tank");
					System.out.println("2. Medium tank");
					System.out.println("3. Big tank");
					System.out.println("4. Home");
					System.out.print("Choose a size of tank: ");
					sc = new Scanner(System.in);
					int chooseSize = sc.nextInt();
					if (chooseSize == 1) {
						communityTank = new CommunityTank("Small Tank");
						listTank.add(communityTank);
						break;
					} else if (chooseSize == 2) {
						communityTank = new CommunityTank("Medium Tank");
						listTank.add(communityTank);
						break;
					} else if (chooseSize == 3) {
						communityTank = new CommunityTank("Big Tank");
						listTank.add(communityTank);
						break;
					} else if (chooseSize == 4)
						break;
					else
						System.out.println("Wrong, try again");
				}

			// create Species Tank
			else if (chooseTank == 2) {
				speciesTank = new SpeciesTank();
				listTank.add(speciesTank);
			}

			// create Specimen Tank
			else if (chooseTank == 3) {
				specimenTank = new SpecimenTank();
				listTank.add(specimenTank);
			} else
				System.out.println("Wrong, try again");
		}
	}

	// add fish intank
	public void addFishInTank() {
		System.out.println("*-----add a fish in tank-----*".toUpperCase());
		if (listTank.isEmpty())
			System.out.println("No any tank to add fish, first of all please add tank!");
		else {
			fish = new Fish();
			displayTank();
			// choose a tank
			System.out.print("Choose a tank to add fish: ");
			sc = new Scanner(System.in);
			int choose = sc.nextInt();
			boolean key = false;
			for (int i = 0; i < listTank.size(); i++)
				if (choose == (i + 1)) {
					key = true;
					if (listTank.get(i).checkFishSuitability(fish)) {
						listTank.get(i).addFish(fish);
						System.out.println("Added!");
						break;
					}
				}
			// not found tank
			if (!key)
				System.out.println("Wrong... try again!");
		}
	}

	// remove fish out tank
	public void removeFishOutTank() {
		System.out.println("*-----remove a fish out tank-----*".toUpperCase());
		if (listTank.isEmpty())
			System.out.println("No any tank to remove fish, first of all please add tank then add fish!");
		else {
			// enter species name want to remove
			System.out.print("Enter species name: ");
			sc = new Scanner(System.in);
			String speciesName = sc.nextLine();
			displayTank();
			// choose a tank
			System.out.print("Choose a tank to remove fish: ");
			sc = new Scanner(System.in);
			int choose = sc.nextInt();
			boolean key = false;
			for (int i = 0; i < listTank.size(); i++)
				if (choose == (i + 1)) {
					key = true;
					if (listTank.get(i).checkFishInTank(speciesName)) {
						listTank.get(i).removeFish(speciesName);
						System.out.println("Removed!");
						break;
					}
				}
			// not found tank
			if (!key)
				System.out.println("Wrong... try again!");
		}
	}

	// move fish in other tank
	public void moveFishInOtherTank() {
		System.out.println("*-----move a fish in other tank-----*".toUpperCase());
		// enter species name need move
		if (listTank.isEmpty())
			System.out.println("No any tank to move fish, first of all please add tank then add fish!");
		else {
			System.out.print("Enter species name: ");
			sc = new Scanner(System.in);
			String speciesName = sc.nextLine();
			displayTank();
			// choose a tank
			System.out.print("Choose tank you want put fish out: ");
			sc = new Scanner(System.in);
			int choose = sc.nextInt();
			boolean key_out = false;
			for (int i = 0; i < listTank.size(); i++)
				if (choose == (i + 1)) {
					key_out = true;
					if (listTank.get(i).checkFishInTank(speciesName)) {
						fish = listTank.get(i).getFishToMove();

						// choose a tank
						System.out.print("Choose tank you want put fish in: ");
						sc = new Scanner(System.in);
						choose = sc.nextInt();
						boolean key_in = false;
						for (int j = 0; j < listTank.size(); j++)
							if (choose == (j + 1)) {
								key_in = true;
								if (listTank.get(j).checkFishSuitability(fish)) {
									listTank.get(j).addFish(fish);
									listTank.get(i).removeFish(speciesName);
									System.out.println("Moved!");
									break;
								}
							}
						// not found tank
						if (!key_in)
							System.out.println("Wrong... try again!");
						// break while chosen
						break;
					}
				}
			// not found tank
			if (!key_out)
				System.out.println("Wrong... try again!");
		}
	}

	// display all fish in tank
	public void displayFishInTank() {
		System.out.println("*-----display fish in all tank-----*".toUpperCase());
		if (listTank.isEmpty())
			System.out.println("No any tank to display fish, first of all please add tank then add fish!");
		else
			for (int i = 0; i < listTank.size(); i++) {
				listTank.get(i).display();
			}
	}

	// display tank while add fish
	public void displayTank() {
		System.out.println("list tank".toUpperCase());
		for (int i = 0; i < listTank.size(); i++) {
			System.out.println((i + 1) + ". " + listTank.get(i).getNAME());
		}
	}
}
