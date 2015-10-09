package demo;

public class Hazchem {
	private String hazchemCode;
	private boolean color; // color = true <-> black, color = false <-> white

	public Hazchem(String hazchemCode, boolean color) throws InvalidHazchemCodeException {
		changeCode(hazchemCode, color);
	}

	public Hazchem(String hazchemCode) {
		this.hazchemCode = hazchemCode;
		this.color = false;
	}

	public String getHazchemCode() {
		return hazchemCode;
	}

	public void setHazchemCode(String hazchemCode) {
		this.hazchemCode = hazchemCode;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public char getReactivity() {
		char[] reactiveCharacters = { 'P', 'S', 'W', 'Y', 'Z' };
		for (char character : reactiveCharacters) {
			if (this.getHazchemCode().charAt(1) == character) {
				return 'V';
			}
		}
		return ' ';
	}

	public String getProtection() {
		char[] colorCharacters = { 'S', 'T', 'Y', 'Z' };
		for (char character : colorCharacters) {
			if (this.getHazchemCode().charAt(1) == character) {
				if (this.isColor()) {
					return "BA for fire only";
				} else {
					return "BA";
				}
			}
		}
		return "Full";
	}

	public String getContainment() {
		char[] secondCharacters = { 'P', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z' };
		int i = 0;
		for (; i < secondCharacters.length; i++) {
			if (this.getHazchemCode().charAt(1) == secondCharacters[i]) {
				break;
			}
		}
		if (i < 4) {
			return "Dilute";
		} else {
			return "Contain";
		}
	}

	public String getEvacuation() {
		if (this.getHazchemCode().length() == 3) {
			return "Consider Evacuation";
		} else {
			return "";
		}
	}

	public void changeCode(String hazchemCode, boolean color) throws InvalidHazchemCodeException {
		char[] secondCharacters = { 'P', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z' };
		char[] colorCharacters = { 'S', 'T', 'Y', 'Z' };
		if (hazchemCode.length() < 2 || hazchemCode.length() > 3) {
			throw new InvalidHazchemCodeException("Invalid HazchemCode!");
		} else {
			if (Character.isDigit(hazchemCode.charAt(0))) {
				if (hazchemCode.charAt(0) < 49 || hazchemCode.charAt(0) > 52) {
					throw new InvalidHazchemCodeException("Invalid first character!");
				} else {
					boolean validCharacter = false;
					for (char character : secondCharacters) {
						if (hazchemCode.charAt(1) == character) {
							validCharacter = true;
							break;
						}
					}
					if (!validCharacter) {
						throw new InvalidHazchemCodeException("Invalid second character!");
					} else {
						if (hazchemCode.length() == 3 && hazchemCode.charAt(2) != 'E') {
							throw new InvalidHazchemCodeException("Invalid third character!");
						} else {
							this.hazchemCode = hazchemCode;
							int i = 0;
							for (; i < colorCharacters.length; i++) {
								if (hazchemCode.charAt(1) == colorCharacters[i]) {
									this.color = color;
									break;
								}
							}
							if (i == colorCharacters.length) {
								this.color = false;
							}
						}
					}
				}
			} else {
				throw new InvalidHazchemCodeException("Invalid character");
			}
		}
	}

	public void changeCode(String hazchemCode) throws InvalidHazchemCodeException {
		this.changeCode(hazchemCode, this.isColor());
	}

	public void getAdvice() {
		String[] materials = { "Jets", "Fog", "Foam", "Dry agent" };
		int firstCharIndex = (int) this.getHazchemCode().charAt(0) - 49;
		String reactiveMsg = "";
		if (this.getReactivity() == 'V') {
			reactiveMsg = "can be violently reactive";
		} else {
			reactiveMsg = "don't panic!";
		}
		String protectiveMsg = "";
		if (this.isColor()) {
			protectiveMsg = "breathing apparatus, protective gloves for fire only";
		} else {
			protectiveMsg = "breathing apparatus, protective gloves";
		}
		String containment = "";
		if (this.getContainment().compareTo("Dilute") == 0) {
			containment = "may be diluted and washed down the drain";
		} else if (this.getContainment().compareTo("Contain") == 0) {
			containment = "must be contained by any means available";
		}
		System.out.println("***Emergency action advice***");
		System.out.println("Material: " + materials[firstCharIndex]);
		System.out.println("Reactivity: " + reactiveMsg);
		System.out.println("Protection: " + protectiveMsg);
		System.out.println("Containment: " + containment);
		System.out.println("Evacuation: " + this.getEvacuation());
		System.out.println("*****************************");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[ " + "code: " + this.getHazchemCode() + ", reversed: "
				+ this.isColor() + " ]";
	}
}
