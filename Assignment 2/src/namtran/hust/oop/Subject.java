package namtran.hust.oop;

import java.util.Scanner;

public class Subject {
	private String subjectID, subjectName;
	private int quota, currentEnrolment;
	private static Scanner sc;

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID() {
		sc = new Scanner(System.in);
		System.out.print("\tEnter subject ID: ");
		this.subjectID = sc.nextLine();
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName() {
		sc = new Scanner(System.in);
		System.out.print("\tEnter subject name: ");
		this.subjectName = sc.nextLine();
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota() {
		sc = new Scanner(System.in);
		System.out.print("\tEnter quota: ");
		this.quota = sc.nextInt();
	}

	public int getCurrentEnrolment() {
		return currentEnrolment;
	}

	public void setCurrentEnrolment(int currentEnrolment) {
		this.currentEnrolment = currentEnrolment;
	}
}
