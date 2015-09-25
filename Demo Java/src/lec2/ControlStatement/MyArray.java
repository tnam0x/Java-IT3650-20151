package lec2.ControlStatement;

import java.util.Scanner;

public class MyArray {
	private static Scanner nhap;

	public static void main(String[] args) {
		nhap = new Scanner(System.in);
		int[] a = null;
		int n;

		do {
			System.out.print("Nhập số phần tử của mảng: ");
			n = nhap.nextInt();
		} while (n < 0);

		a = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + (i + 1) + "]=");
			a[i] = nhap.nextInt();
		}

		System.out.println("Mảng đã nhập là: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.print("\nNhập vị trí phần tử cần tìm kiếm: ");
		int m = nhap.nextInt();
		for (int i = 0; i < a.length; i++) {
			if (i == m)
				System.out.println("Giá trị phần tử thứ " + i + " là: " + a[i]);
		}
	}
}
