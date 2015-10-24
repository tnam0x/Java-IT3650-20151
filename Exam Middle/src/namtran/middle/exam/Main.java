package namtran.middle.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static ArrayList<Student> listStudent;
	private static Student student;
	private float maxPoint, minPoint, averagePoint;
	private int imaxPoint, iminPoint;
	private static boolean flagSorted;
	private String[] check = { "", "", "", "", "", "", "", "", "", "", "" };

	public static void main(String[] args) {
		Main main = new Main();
		sc = new Scanner(System.in);
		// create
		main.createStudent();
		System.out.println("Press Enter key to continue...");
		sc.nextLine();

		// display
		main.displayStudent();
		main.displaySortStudentByPoint();
		main.displayHistogram();
	}

	public void createStudent() {
		listStudent = new ArrayList<Student>();
		System.out.println("*-----create student-----*".toUpperCase());
		while (true) {
			student = new Student();
			sc = new Scanner(System.in);
			System.out.print("Enter name: ");
			student.setName(sc.nextLine());
			System.out.print("Enter id: ");
			student.setId(sc.nextLine());
			student.setPoint();
			listStudent.add(student);

			System.out.println("Do you want to continue? [Y/N]");
			sc = new Scanner(System.in);
			if ("y".equalsIgnoreCase(sc.nextLine()))
				continue;
			else
				break;
		}
	}

	public void displayStudent() {
		System.out.println("*-----display information-----*".toUpperCase());
		if (flagSorted)
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm giảm dần");
		else {
			System.out.println("Total number of students: " + listStudent.size());
			System.out.println("Code: " + student.getCode());
			System.out.println("Title: " + student.getTitle());
			displayStudentGetMostPoint();
		}
		for (int i = 0; i < listStudent.size(); i++) {
			System.out.println("Student " + (i + 1));
			System.out.println("\tName: " + listStudent.get(i).getName());
			System.out.println("\tID: " + listStudent.get(i).getId());
			System.out.println("\tPoint: " + listStudent.get(i).getPoint());
		}
	}

	public void displayStudentGetMostPoint() {
		// determind max point, min point, average point
		maxPoint = minPoint = listStudent.get(0).getPoint();
		for (int i = 0; i < listStudent.size(); i++) {
			// average point
			averagePoint += listStudent.get(i).getPoint();
			averagePoint = averagePoint / listStudent.size();
			averagePoint = Math.round((averagePoint * 10) / 10);

			// max, min
			if (maxPoint < listStudent.get(i).getPoint()) {
				maxPoint = listStudent.get(i).getPoint();
				imaxPoint = i;
			}
			if (minPoint > listStudent.get(i).getPoint()) {
				minPoint = listStudent.get(i).getPoint();
				iminPoint = i;
			}
		}
		// display
		System.out.println("The student with the highest mark is " + listStudent.get(imaxPoint).getName().toUpperCase()
				+ " with " + maxPoint + " point");
		System.out.println("The student with the lowest mark is " + listStudent.get(iminPoint).getName().toUpperCase()
				+ " with " + minPoint + " point");
		System.out.println("The average mark is: " + averagePoint);
	}

	public void displaySortStudentByPoint() {
		Collections.sort(listStudent, new StudentSort());
		flagSorted = true;
		displayStudent();
	}

	public void displayHistogram() {
		checkPoint();
		System.out.println("A histogram of the subject Database programing is:");
		System.out.println("<=9:" + check[0]);
		System.out.println("10-19:" + check[1]);
		System.out.println("20-29:" + check[2]);
		System.out.println("30-39:" + check[3]);
		System.out.println("40-49:" + check[4]);
		System.out.println("50-59:" + check[5]);
		System.out.println("60-69:" + check[6]);
		System.out.println("70-79:" + check[7]);
		System.out.println("80-89:" + check[8]);
		System.out.println("90-99:" + check[9]);
		System.out.println("100:" + check[10]);
	}

	public void checkPoint() {
		for (int i = 0; i < listStudent.size(); i++) {
			float point = listStudent.get(i).getPoint();
			if (0 <= point && point <= 9)
				check[0] += "*";
			if (10 <= point && point <= 19)
				check[1] += "*";
			if (20 <= point && point <= 29)
				check[2] += "*";
			if (30 <= point && point <= 39)
				check[3] += "*";
			if (40 <= point && point <= 49)
				check[4] += "*";
			if (50 <= point && point <= 59)
				check[5] += "*";
			if (60 <= point && point <= 69)
				check[6] += "*";
			if (70 <= point && point <= 79)
				check[7] += "*";
			if (80 <= point && point <= 89)
				check[8] += "*";
			if (90 <= point && point <= 99)
				check[9] += "*";
			if (point == 100)
				check[10] += "*";
		}
	}
}
