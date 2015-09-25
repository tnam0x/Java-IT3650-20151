package lec3.BasicOOP;

import java.util.Scanner;

public class SubjectManagement {
	private static Scanner nhap;

	public static void main(String[] args) {
		Subject subject = new Subject();

		System.out.println("Enter information of subject");
		System.out.print("\tSubject name: ");
		nhap = new Scanner(System.in);
		subject.setSubjectName(nhap.nextLine());

		System.out.print("\tSubject ID: ");
		subject.setSubjectID(nhap.nextLine());

		System.out.print("\tQuota: ");
		subject.setQuota(nhap.nextInt());

		new Subject(subject.getSubjectName(), subject.getSubjectID(), subject.getQuota(), 0);

		System.out.println("*=====Information of Subject=====*");
		subject.displaySubjectInfo();

		do {
			System.out.println("*=====Enrolment Subject=====*");
			subject.enrolStudent();

			System.out.println("Do you want to continue (Y/N)?");
			nhap = new Scanner(System.in);

		} while ("Y".equalsIgnoreCase(nhap.nextLine()));
		System.out.println("*=====Information of Subject=====*");
		subject.displaySubjectInfo();

		do {
			System.out.println("*=====Unenrolment Subject=====*");
			subject.unEnrolStudent();

			System.out.println("Do you want to continue (Y/N)?");
			nhap = new Scanner(System.in);

		} while ("Y".equalsIgnoreCase(nhap.nextLine()));
		System.out.println("*=====Information of Subject=====*");
		subject.displaySubjectInfo();
	}
}
