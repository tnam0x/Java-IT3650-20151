package demo;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {
	private static Scanner inputData;

	public static void restrictedContent() throws IOException {
		int age;
		System.out.println("This page contains 18+ contents. How old are you?");
		inputData = new Scanner(System.in);
		age = inputData.nextInt();
		if (age < 18)
			throw new IOException("You’re restricted!");
	}

	public static void main(String arg[]) {
		try {
			restrictedContent();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
