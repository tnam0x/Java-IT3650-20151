package lec6.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int x, fx;
		boolean check = true;
		Scanner inputData;
		while (check) {
			inputData = new Scanner(System.in);
			System.out.print("Enter x: ");
			try {
				x = inputData.nextInt();
				fx = 1 / x;
				System.out.println("f(x) = " + fx);
				check = false;
			} catch (InputMismatchException inputMisException) {
				System.out.println("You entered not-integer value!");
				break;
			} catch (ArithmeticException arithException) {
				System.out.println("Error " + arithException);
				check = true;
			}
		}
	}
}
