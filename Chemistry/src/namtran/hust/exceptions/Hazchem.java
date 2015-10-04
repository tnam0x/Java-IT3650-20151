package namtran.hust.exceptions;

import java.util.Scanner;

public class Hazchem {
	private String codeHazchem;
	private boolean isColor;
	private boolean reactivity;
	private String protection;
	private String containment;
	private String evacuation;
	private String material;
	private static Scanner sc;
	private final String[] MATERIAL = { "Jets", "Fog", "Foam", "Dry agent" };
	private final char[] SECOND_CHAR = { 'P', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z' };

	public Hazchem(String codeHazchem, boolean isColor) throws InvalidHazchemCodeException {
		boolean checkFirstCharacter = false, checkSecondCharacter = false;
		// kiem tra co du 2-3 ki tu
		if ((codeHazchem.length() == 3 && codeHazchem.charAt(2) == 'E') || codeHazchem.length() == 2)
			// kiem tra ki tu dau tien la so
			if (Character.isDigit(codeHazchem.charAt(0))) {
				// kiem tra ki tu dau tien la so 1-4
				for (int i = 1; i < 5; i++)
					if (codeHazchem.charAt(0) == (48 + i)) {
						checkFirstCharacter = true;
						// kiem tra ki tu thu 2
						for (int j = 0; j < SECOND_CHAR.length; j++)
							if (SECOND_CHAR[j] == codeHazchem.charAt(1)) {
								checkSecondCharacter = true;
								// kiem tra ki tu thu 2 co mau gi (neu can)
								if (SECOND_CHAR[j] == 'S' || SECOND_CHAR[j] == 'T' || SECOND_CHAR[j] == 'Y'
										|| SECOND_CHAR[j] == 'Z') {
									System.out.print("Is the " + SECOND_CHAR[j] + " reverse coloured?[y/n] ");
									sc = new Scanner(System.in);
									String answer = sc.nextLine();
									if (answer.equals("y"))
										changeCode(codeHazchem, true);
									else
										changeCode(codeHazchem);
								}
								break;
							}
						if (!checkSecondCharacter)
							throw new InvalidHazchemCodeException("Second characters invalid!");
					}
				if (!checkFirstCharacter)
					throw new InvalidHazchemCodeException("First characters must be numbers 1-4!");
			} else
				throw new InvalidHazchemCodeException("First characters is a number!");
		else
			throw new InvalidHazchemCodeException("Hazchem code must have 2-3 characters are valid!");
	}

	public void changeCode(String codeHazchem, boolean isColor) {
		this.codeHazchem = codeHazchem;
		this.isColor = isColor;
		if (codeHazchem.length() == 3)
			this.evacuation = "E";
		else
			this.evacuation = "";
	}

	public Hazchem(String codeHazchem) {
		if (codeHazchem.length() == 3)
			this.evacuation = "E";
		else
			this.evacuation = "";
		changeCode(codeHazchem);
	}

	public void changeCode(String codeHazchem) {
		this.codeHazchem = codeHazchem;
		this.isColor = false;
	}

	public void getAdvice() {
		for (int i = 1; i < 5; i++) {
			if (codeHazchem.charAt(0) == (i+48))
				material = MATERIAL[i - 1];
		}
		if (isColor)
			protection = "BA for fire only";
		else if (codeHazchem.charAt(1) == 'P' || codeHazchem.charAt(1) == 'R' || codeHazchem.charAt(1) == 'X'
				|| codeHazchem.charAt(1) == 'W')
			protection = "Full";
		else
			protection = "BA";
		if (codeHazchem.charAt(1) == 'P' || codeHazchem.charAt(1) == 'R' || codeHazchem.charAt(1) == 'S'
				|| codeHazchem.charAt(1) == 'T')
			containment = "Dilute";
		else
			containment = "Contain";
		if (codeHazchem.charAt(1) == 'R' || codeHazchem.charAt(1) == 'T' || codeHazchem.charAt(1) == 'X')
			reactivity = false;
		else
			reactivity = true;

	}

	public String toString() {
		String str = "Hazchem[ code: " + codeHazchem + ", reversed: " + isColor + " ]";
		return str;
	}

	public boolean isReactivity() {
		return reactivity;
	}

	public String getProtection() {
		return protection;
	}

	public String getContainment() {
		return containment;
	}

	public String getEvacuation() {
		return evacuation;
	}

	public String getMaterial() {
		return material;
	}
}
