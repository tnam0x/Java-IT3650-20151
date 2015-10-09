package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InvalidHazchemCodeException, IOException {
		// TODO Auto-generated method stub
		/* 3. First program */
		String response = "Y";
		do {
			String hazchemCode = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter HAZCHEM code: ");
			hazchemCode = br.readLine();
			System.out.print("Is the " + hazchemCode.charAt(1) + " reverse coloured? ");
			boolean color = true;
			response = br.readLine();
			if (response.compareToIgnoreCase("N") == 0) {
				color = false;
			}
			Hazchem hzCode = null;
			try {
				hzCode = new Hazchem(hazchemCode, color);
				System.out.println(hzCode.toString());
				hzCode.getAdvice();
			} catch (InvalidHazchemCodeException e) {
				System.out.println(e);
			}
			System.out.print("Is more advice needed (y/n): ");
			response = br.readLine();
			if (response.compareToIgnoreCase("N") == 0) {
				break;
			}
		} while (response.compareToIgnoreCase("Y") == 0);

		/* 4. Second program */
		String reply = "Y";
		do {
			// String workingDir = System.getProperty("user.dir");
			System.out.print("Enter the file name that contain Hazchem Code: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String fileName = br.readLine();
			File file = new File(fileName);
			String hazchemCode = "";
			Hazchem hzCode = new Hazchem(hazchemCode);
			if (file.exists() && !file.isDirectory()) {
				Scanner scanner = new Scanner(file);
				if (scanner.hasNextLine()) {
					hazchemCode = scanner.nextLine();
					hzCode = new Hazchem(hazchemCode);
					System.out.println(hzCode.toString());
					hzCode.getAdvice();
				} else {
					System.out.print("Invalid hazchem code file!");
				}
				scanner.close();
				System.out.print("Do you want to change this hazchem code?(Y/N): ");
			} else {
				System.out.println("Warning: no such file or directory!");
				System.out.print("Do you want to enter new hazchem code?(Y/N): ");
			}
			reply = br.readLine();
			if (reply.compareToIgnoreCase("Y") == 0) {
				boolean isValid = false;
				do {
					System.out.print("Enter hazchem code: ");
					hazchemCode = br.readLine();
					try {
						hzCode.changeCode(hazchemCode);
						isValid = true;
					} catch (InvalidHazchemCodeException e) {
						System.out.println(e);
					}
				} while (!isValid);
			}
			System.out.print("Enter new file name to save current hazchem code: ");
			reply = br.readLine();
			try (FileWriter writer = new FileWriter(reply)) {
				writer.write(hazchemCode);
				file.delete();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.print("Do you want to continue?(Y/N): ");
			reply = br.readLine();
			if (reply.compareToIgnoreCase("N") == 0) {
				break;
			}
		} while (reply.compareToIgnoreCase("Y") == 0);
	}

}
