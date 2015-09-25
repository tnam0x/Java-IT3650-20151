package lec2.ControlStatement;

import java.util.Scanner;

public class Switch_Case {
	private static Scanner nhap;

	public static void main(String[] args) {
		nhap = new Scanner(System.in);
		System.out.print("Nhập 1 số bất kì: ");
		int x = nhap.nextInt();
		switch (x % 3) {
		case 0:
			System.out.println("Dư 0");
			break;
		case 1:
			System.out.println("Dư 1");
			break;
		case 2:
			System.out.println("Dư 2");
			break;
		default:
			System.out.println("Default");
		}
	}
}
