package namtran.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Trần Xuân Nam
 * @serial 20122126
 */
public class ListStudent {
	private static Scanner nhap;
	private static Student student;
	private static ArrayList<Student> aList;

	public static void main(String[] args) {
		System.out.print("Enter number of student: ");
		nhap = new Scanner(System.in);
		int numberOfStudent = nhap.nextInt();

		aList = new ArrayList<Student>();
		for (int i = 0; i < numberOfStudent; i++) {
			student = new Student();
			System.out.println("Enter information of student: ");
			student.setName();
			student.setId();
			student.setScore();
			aList.add(student);
		}

		System.out.println("==========Information of Students==========");
		for (int i = 0; i < numberOfStudent; i++) {
			System.out.println("Name: " + aList.get(i).getName().toUpperCase());
			System.out.println("ID: " + aList.get(i).getId());
			System.out.println("Score: " + aList.get(i).getScore());
			System.out.println("------------------------------");
		}

		String answer;
		do {
			int show = 0;
			System.out.print("Enter student's name to search: ");
			nhap = new Scanner(System.in);
			String nameToSearch = nhap.nextLine();
			for (int i = 0; i < numberOfStudent; i++) {
				if (nameToSearch.equalsIgnoreCase(aList.get(i).getName())) {
					System.out.println("Score of " + nameToSearch.toUpperCase() + " is: " + aList.get(i).getScore());
					show++;
				}
			}
			if (show == 0)
				System.out.println("Not found!");

			System.out.print("Do you want to continue (Y/N)? ");
			nhap = new Scanner(System.in);
			answer = nhap.nextLine();
		} while (answer.equalsIgnoreCase("Y"));

		int mostScore = 0;
		int numberOfStudentGetMostScore = 0;
		for (int i = 0; i < numberOfStudent; i++) {
			int count = 0;
			int compare = aList.get(i).getScore();
			for (int j = 0; j < numberOfStudent; j++) {
				if (compare == aList.get(j).getScore())
					count++;
			}

			if (numberOfStudentGetMostScore <= count) {
				numberOfStudentGetMostScore = count;
				mostScore = compare;
			}
		}

		System.out.println("------------------------------");
		System.out.println("Have " + numberOfStudentGetMostScore + " student get " + mostScore + " mark!");
	}
}
