package namtran.hust.oop;

import java.util.Scanner;

public class Fish {
	private String speciesName;
	private float minpH, maxpH;
	private String salinities;
	private String temperature;
	private boolean feature;
	private static Scanner sc;

	/**
	 * @param name
	 * @param minpH
	 * @param maxpH
	 * @param salinities
	 * @param temperature
	 * @param feature
	 */
	public Fish() {
		// tên loài
		System.out.println("create fish".toUpperCase());
		System.out.print("Enter species name: ");
		sc = new Scanner(System.in);
		speciesName = sc.nextLine();

		// min, max pH
		System.out.print("Enter min pH: ");
		sc = new Scanner(System.in);
		minpH = sc.nextFloat();
		System.out.print("Enter max pH: ");
		sc = new Scanner(System.in);
		maxpH = sc.nextFloat();

		// nồng độ muối
		System.out.print("Enter salinities (F[<0.5%], B[0.5%-5%] or S[5%-18%]): ");
		sc = new Scanner(System.in);
		salinities = sc.nextLine();

		// nhiệt độ
		System.out.print("Enter temperature ([N]hiệt đới/[H]àn đới): ");
		sc = new Scanner(System.in);
		String chooseTemp = sc.nextLine();
		if ("n".equalsIgnoreCase(chooseTemp))
			temperature = "Nhiệt Đới";
		else if ("h".equalsIgnoreCase(chooseTemp))
			temperature = "Hàn Đới";
		else
			System.out.println("Không hợp lệ!");

		// thông tin loài có hung dữ hay không
		System.out.print("Loài không hung dữ [1] hay hung dữ [0]? ");
		sc = new Scanner(System.in);
		int choose = sc.nextInt();
		if (choose == 1)
			feature = true;
		else if (choose == 0)
			feature = false;
		else
			System.out.println("Không hợp lệ!");
	}

	@Override
	public String toString() {
		String str = "";
		String feature = "";
		if (this.feature)
			feature = "không hung dữ";
		else
			feature = "hung dữ";
		str += "Fish name: " + speciesName + ", Min pH: " + minpH + ", Max pH: " + maxpH + ", Salinities: "
				+ salinities.toUpperCase() + ", Temperature: " + temperature + ", Feature: " + feature;
		return str;
	}

	public boolean checkEnviroment(float pH, float salinities, String temperature) {
		boolean result = false;
		if (minpH <= pH && pH <= maxpH)
			if (checkSalinities(salinities))
				if (temperature.equalsIgnoreCase(this.temperature))
					result = true;
		return result;
	}

	public boolean checkSalinities(float salinities) {
		boolean result = false;
		String toStringSalinities = "";
		if (salinities < 0.5)
			toStringSalinities = "F";
		else if (0.5 <= salinities && salinities <= 5)
			toStringSalinities = "B";
		else if (5 < salinities && salinities <= 18)
			toStringSalinities = "S";
		if (this.salinities.equalsIgnoreCase(toStringSalinities))
			result = true;
		return result;
	}

	public boolean isFeature() {
		return feature;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public String getTemperature() {
		return temperature;
	}
}
