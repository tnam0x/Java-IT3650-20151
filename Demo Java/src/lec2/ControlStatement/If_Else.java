package lec2.ControlStatement;

import java.util.Scanner;

/*tìm nghiệm pt bậc nhất ax + b = 0*/
/**
 * @author namal
 *
 */
public class If_Else {
	private static Scanner nhap;

	public static void main(String[] args) {
		double a, b;
		while (true) {
			nhap = new Scanner(System.in);
			System.out.print("Nhap vao a: ");
			a = nhap.nextDouble();
			if (a != 0) {
				System.out.print("Nhap vao b: ");
				b = nhap.nextDouble();
				break;
			} else
				System.out.println("Khong hop le, nhap lai!");
		}
		double x = -b / a;
		System.out.println("Nghiem pt bac nhat la: " + x);
	}
}
