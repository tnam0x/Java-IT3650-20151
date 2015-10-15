package namtran.hust.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectManagement {
	private static ArrayList<Subject> listSubject;
	private static Subject subject;
	private static Scanner sc;
	private static int maxSubject = 2;
	private static int numberOfStudentsReceive;
	private static int iDTransmit;
	private static int iDReceive;

	public static void main(String[] args) {
		SubjectManagement sm = new SubjectManagement();
		// create list subject
		listSubject = new ArrayList<>();
		do {
			subject = new Subject();
			System.out.println("Enter information of subject");
			subject.setSubjectName();
			subject.setSubjectID();
			subject.setQuota();
			listSubject.add(subject);
			--maxSubject;
			// break if max subject
			if (maxSubject == 0) {
				System.out.println("Subject reached, can't add, max is " + maxSubject);
				break;
			}
			// continue
			else {
				System.out.println("Do you want to continue? [Y/N]");
				sc = new Scanner(System.in);
			}
		} while ("y".equalsIgnoreCase(sc.nextLine()) && maxSubject != 0);
		sm.displaySubjectInfo();
		sm.searchSubject();

		// transmit student in others one
		System.out.println("*=====Transmit student in others one=====*");
		// can't transmit
		if (listSubject.size() < 2)
			System.out.println("can't transmit, not enough subjects, have " + listSubject.size() + " subject");
		// transmit
		else {
			while (true) {
				int run = 0;
				System.out.print("Enter subject ID need transmit students: ");
				sc = new Scanner(System.in);
				String idTransmit = sc.nextLine();
				for (int i = 0; i < listSubject.size(); i++) {
					if (listSubject.get(i).getSubjectID().equalsIgnoreCase(idTransmit)) {
						iDTransmit = i;
						++run;
						while (true) {
							System.out.print("Enter subject ID need receive students: ");
							sc = new Scanner(System.in);
							String idReceive = sc.nextLine();
							for (int j = 0; j < listSubject.size(); j++) {
								if (listSubject.get(j).getSubjectID().equalsIgnoreCase(idReceive) && j != iDTransmit) {
									iDReceive = j;
									System.out.print("Enter number of students need transmit: ");
									sc = new Scanner(System.in);
									numberOfStudentsReceive = sc.nextInt();
									if (numberOfStudentsReceive <= listSubject.get(iDTransmit).getCurrentEnrolment())
										sm.transmitStudents();
									else
										System.out.println("Can't transmit, out of quota!");
								}
							}
							break;
						}
					}
				}
				// not found subject id
				if (run == 0) {
					System.out.println("Not found ID!");
					break;
				}
				break;
			}
		}
	}

	public void searchSubject() {
		SubjectManagement sm = new SubjectManagement();
		int run = 0;
		while (true) {
			System.out.print("Enter subject ID to search or S to skip: ");
			sc = new Scanner(System.in);
			String id = sc.nextLine();
			// skip
			if ("s".equalsIgnoreCase(id))
				break;
			for (int i = 0; i < listSubject.size(); i++) {
				if (listSubject.get(i).getSubjectID().equalsIgnoreCase(id)) {
					++run;
					while (true) {
						System.out.println("Do you want (E)nrolStudent or (U)nEnrolStudent or Any key to back?");
						sc = new Scanner(System.in);
						String choose = sc.nextLine();
						// enrolStudent
						if ("e".equalsIgnoreCase(choose)) {
							if (listSubject.get(i).getCurrentEnrolment() < listSubject.get(i).getQuota()) {
								do {
									System.out.print("Enrolling student... ");
									listSubject.get(i)
											.setCurrentEnrolment(listSubject.get(i).getCurrentEnrolment() + 1);
									System.out.println(
											"Student enrolled in " + listSubject.get(i).getSubjectName().toUpperCase());
									// break if full slot
									if (listSubject.get(i).getCurrentEnrolment() == listSubject.get(i).getQuota()) {
										System.out.println("Quota reached, enrolment failed!");
										break;
									}
									// continue if not full slot
									else {
										System.out.println("Do you want to continue? [Y/N]");
										sc = new Scanner(System.in);
									}
								} while ("y".equalsIgnoreCase(sc.nextLine())
										&& listSubject.get(i).getCurrentEnrolment() < listSubject.get(i).getQuota());
							}
							// enrolment failed
							else {
								System.out.print("Enrolling student... ");
								System.out.println("Quota reached, enrolment failed!");
							}
							sm.displaySubjectInfo();
						}
						// unEnrolStudent
						else if ("u".equalsIgnoreCase(choose)) {
							// no students to un-enrol
							if (listSubject.get(i).getCurrentEnrolment() <= 0) {
								System.out.print("Un-enrolling student... ");
								System.out.println("No students to un-enrol");
							}
							// enrolling student
							else {
								do {
									System.out.print("Un-enrolling student... ");
									listSubject.get(i)
											.setCurrentEnrolment(listSubject.get(i).getCurrentEnrolment() - 1);
									System.out.println("Student un-enrolled from "
											+ listSubject.get(i).getSubjectName().toUpperCase());
									// break if no student
									if (listSubject.get(i).getCurrentEnrolment() == 0) {
										System.out.println("No students to un-enrol");
										break;
									}
									// continue if have students
									else {
										System.out.println("Do you want to continue? [Y/N]");
										sc = new Scanner(System.in);
									}
								} while ("y".equalsIgnoreCase(sc.nextLine())
										&& listSubject.get(i).getCurrentEnrolment() > 0);
							}
							sm.displaySubjectInfo();
						}
						// type wrong
						else
							break;
					}
				}
			}
			// not found subject id
			if (run == 0)
				System.out.println("Not found ID, try again...");
		}
	}

	// display info
	public void displaySubjectInfo() {
		System.out.println("*=====Information of Subject=====*");
		for (int i = 0; i < listSubject.size(); i++) {
			System.out.println("Subject " + (i + 1));
			System.out.println("\tSubject name: " + listSubject.get(i).getSubjectName().toUpperCase());
			System.out.println("\tSubject ID: " + listSubject.get(i).getSubjectID());
			System.out.println("\tQuota: " + listSubject.get(i).getQuota());
			System.out.println("\tCurrently enrolled: " + listSubject.get(i).getCurrentEnrolment());
			int availablePlaces = listSubject.get(i).getQuota() - listSubject.get(i).getCurrentEnrolment();
			System.out.println("\tCan accept " + availablePlaces + " more students");
		}
	}

	// transmit students
	public void transmitStudents() {
		int numberOfStudents = numberOfStudentsReceive + listSubject.get(iDReceive).getCurrentEnrolment();
		int numberOfStudentsRemain = listSubject.get(iDTransmit).getCurrentEnrolment() - numberOfStudentsReceive;
		// transmitting
		if (listSubject.get(iDReceive).getQuota() >= numberOfStudents) {
			listSubject.get(iDTransmit).setCurrentEnrolment(numberOfStudentsRemain);
			listSubject.get(iDReceive).setCurrentEnrolment(numberOfStudents);
			System.out.println("Transmitted " + numberOfStudentsReceive + " students from subject "
					+ listSubject.get(iDTransmit).getSubjectName().toUpperCase() + " to "
					+ listSubject.get(iDReceive).getSubjectName().toUpperCase());
		} else
			System.out.println("Can't receive, out of quota!");
		// display
		displaySubjectInfo();
	}
}
