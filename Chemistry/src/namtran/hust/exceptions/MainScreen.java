package namtran.hust.exceptions;

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
			} catch (InvalidHazchemCodeException iCE) {
				System.out.println(iCE.getMessage());
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
}
