package lec5.Exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThrowsException {
	public static void main(String[] args) {
		ThrowsException te = new ThrowsException();
		te.getData();
	}

	public void getData() {
		int intData = 0;
		double doubleData = 0;
		String strData = null;
		try {
			intData = getInt();
			doubleData = getDouble();
			strData = getString();
			System.out.println(intData + " " + doubleData + " " + strData);
		} catch (Exception e) {
			System.out.println("Could not enter data!");
			System.out.println("Error: " + e);
		}
	}

	private int getInt() throws Exception {
		int data = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.print("Enter an integer: ");
		str = br.readLine();
		data = Integer.parseInt(str);
		return data;
	}

	private double getDouble() throws Exception {
		double data = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.print("Enter an double: ");
		str = br.readLine();
		data = Double.parseDouble(str);
		return data;
	}

	private String getString() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.print("Enter a string: ");
		str = br.readLine();
		return str;
	}
}
