package namtran.hust.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class MainScreen {
	private static Hazchem hazchem;
	private static Scanner sc;

	public static void main(String[] args) {
		while (true) {
			// enter code
			System.out.print("Enter HAZCHEM code: ");
			sc = new Scanner(System.in);
			String codeHazchem = sc.nextLine();
			try {
				hazchem = new Hazchem(codeHazchem, false);
				hazchem.getAdvice();
				display();
			} catch (InvalidHazchemCodeException e) {
				System.out.println(e.getMessage());
			}
			// comtinue?
			System.out.print("Is more advice needed [y/n]: ");
			sc = new Scanner(System.in);
			String answer = sc.nextLine();
			if (answer.equalsIgnoreCase("y"))
				continue;
			else
				break;
		}
		try {
			workWithFile();
		} catch (FileNotFoundException | InvalidHazchemCodeException e) {
			System.out.println(e.getMessage());
		}
	}

	// display information
	public static void display() {
		// display code
		System.out.println();
		System.out.println(hazchem);
		// display instruction
		System.out.println("***Emergency action advice***");
		System.out.println("Material: " + hazchem.getMaterial());
		if (hazchem.isReactivity())
			System.out.println("Reactivity: can be violently reactive");
		else
			System.out.println("Reactivity: can't be violently reactive");
		if ("Full".equalsIgnoreCase(hazchem.getProtection()))
			System.out.println("Protection: protecting the body with clothes and masks");
		else if ("BA".equalsIgnoreCase(hazchem.getProtection()))
			System.out.println("Protection: breathing apparatus, protective gloves");
		else
			System.out.println("Protection: breathing apparatus, protective gloves for fire only");
		if ("Dilute".equalsIgnoreCase(hazchem.getContainment()))
			System.out.println("Containment: may be diluted and washed down the drain");
		else
			System.out.println("Containment: must be contained by any means available");
		if (hazchem.getEvacuation().equalsIgnoreCase("E"))
			System.out.println("Evacuation:  consider evacuation");
		else
			System.out.println("Evacuation:");
		System.out.println("*****************************");
	}

	// work with file
	public static void workWithFile() throws InvalidHazchemCodeException, FileNotFoundException {
		System.out.println("***Work with file***");
		do {
			System.out.print("Enter the file name that contain Hazchem code: ");
			sc = new Scanner(System.in);
			File file = new File(sc.nextLine());
			String hazchemCode = "";
			if (file.exists() && !file.isDirectory()) {
				sc = new Scanner(file);
				if (sc.hasNextLine()) {
					hazchemCode = sc.nextLine();
					hazchem = new Hazchem(hazchemCode, false);
					hazchem.getAdvice();
					display();
				} else
					System.out.println("Invalid hazchem code file!");
				sc.close();
				System.out.print("Do you want to change this Hazchem code? [y/n]: ");
			} else {
				System.out.println("Warning: no such file or directory!");
				System.out.print("Do you want to enter new Hazchem code? [y/n]: ");
			}
			sc = new Scanner(System.in);
			String reply = sc.nextLine();
			if ("y".equalsIgnoreCase(reply)) {
				boolean isValid = false;
				do {
					System.out.print("Enter new Hazchem code: ");
					hazchemCode = sc.nextLine();
					try {
						hazchem = new Hazchem(hazchemCode, false);
						isValid = true;
					} catch (InvalidHazchemCodeException e) {
						System.out.println(e.getMessage());
					}
				} while (!isValid);
			}
			System.out.print("Enter new file name to save current hazchem code: ");
			sc = new Scanner(System.in);
			reply = sc.nextLine();
			try (FileWriter writer = new FileWriter(reply)) {
				writer.write(hazchemCode);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			file.delete();
			System.out.print("Do you want to continue?[y/n]: ");
			sc = new Scanner(System.in);
			reply = sc.nextLine();
			if ("y".equalsIgnoreCase(reply))
				continue;
			else
				break;
		} while (true);
	}
}
