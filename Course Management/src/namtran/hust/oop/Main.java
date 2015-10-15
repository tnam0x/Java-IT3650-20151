package namtran.hust.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private ArrayList<Student> listStudent;
	private ArrayList<Teacher> listTeacher;
	private ArrayList<Course> listCourse;
	private Student student;
	private Teacher teacher;
	private Course course;
	private static boolean flagSorted;
	private int imaxPoint, iminPoint, maxPoint, minPoint;

	public static void main(String[] args) {
		Main main = new Main();
		sc = new Scanner(System.in);

		// create
		main.createListStudent();
		main.createListTeacher();
		main.createCourse();
		System.out.println("Press Enter key to continue...");
		sc.nextLine();

		// display
		main.displayStudent();
		main.displayTeacher();
		main.displayStudentGetMostPoint();
		main.displaySortStudentByPoint();
		main.displayCourse();
	}

	public void createListStudent() {
		listStudent = new ArrayList<>();
		System.out.println("create list student".toUpperCase());
		while (true) {
			student = new Student();
			sc = new Scanner(System.in);
			System.out.print("Enter name: ");
			student.setName(sc.nextLine());
			System.out.print("Enter age: ");
			student.setAge(sc.nextInt());
			System.out.print("Enter address: ");
			sc = new Scanner(System.in);
			student.setAddress(sc.nextLine());
			System.out.print("Enter mssv: ");
			student.setMssv(sc.nextLine());
			System.out.print("Enter niên khoá: ");
			student.setNienKhoa(sc.nextLine());
			System.out.print("Enter điểm môn học: ");
			student.setDiemMonHoc(sc.nextInt());
			listStudent.add(student);

			System.out.println("Do you want to continue? [Y/N]");
			sc = new Scanner(System.in);
			if ("y".equalsIgnoreCase(sc.nextLine()))
				continue;
			else
				break;
		}
	}

	public void createListTeacher() {
		listTeacher = new ArrayList<>();
		System.out.println("*-----create list teacher-----*".toUpperCase());
		while (true) {
			teacher = new Teacher();
			sc = new Scanner(System.in);
			System.out.print("Enter name: ");
			teacher.setName(sc.nextLine());
			System.out.print("Enter age: ");
			teacher.setAge(sc.nextInt());
			System.out.print("Enter address: ");
			sc = new Scanner(System.in);
			teacher.setAddress(sc.nextLine());
			System.out.print("Enter msgv: ");
			teacher.setMsgv(sc.nextLine());
			System.out.print("Enter chuyên môn: ");
			teacher.setChuyenMon(sc.nextLine());
			listTeacher.add(teacher);

			System.out.println("Do you want to continue? [Y/N]");
			sc = new Scanner(System.in);
			if ("y".equalsIgnoreCase(sc.nextLine()))
				continue;
			else
				break;
		}
	}

	public void createCourse() {
		System.out.println("*-----create course-----*".toUpperCase());
		listCourse = new ArrayList<>();
		course = new Course();
		sc = new Scanner(System.in);
		System.out.print("Enter course name: ");
		course.setCourseName(sc.nextLine());
		course.setListStudent(listStudent);
		System.out.println("Add list student... done!");
		course.setListTeacher(listTeacher);
		System.out.println("Add list teacher... done!");
		listCourse.add(course);
	}

	public void displayStudent() {
		System.out.println("*-----display list students-----*".toUpperCase());
		if (flagSorted)
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm giảm dần");
		maxPoint = minPoint = listStudent.get(0).getDiemMonHoc();
		for (int i = 0; i < listStudent.size(); i++) {
			System.out.println("Name: " + listStudent.get(i).getName());
			System.out.println("Age: " + listStudent.get(i).getAge());
			System.out.println("Address: " + listStudent.get(i).getAddress());
			System.out.println("MSSV: " + listStudent.get(i).getMssv());
			System.out.println("Niên khoá: " + listStudent.get(i).getNienKhoa());
			System.out.println("Điểm môn học: " + listStudent.get(i).getDiemMonHoc());
			System.out.println("*****************************************");

			// determind max point, min point
			if (maxPoint < listStudent.get(i).getDiemMonHoc()) {
				maxPoint = listStudent.get(i).getDiemMonHoc();
				imaxPoint = i;
			}
			if (minPoint > listStudent.get(i).getDiemMonHoc()) {
				minPoint = listStudent.get(i).getDiemMonHoc();
				iminPoint = i;
			}
		}
	}

	public void displayTeacher() {
		System.out.println("*-----display list teacher-----*".toUpperCase());
		for (int i = 0; i < listTeacher.size(); i++) {
			System.out.println("Name: " + listTeacher.get(i).getName());
			System.out.println("Age: " + listTeacher.get(i).getAge());
			System.out.println("Address: " + listTeacher.get(i).getAddress());
			System.out.println("MSGV: " + listTeacher.get(i).getMsgv());
			System.out.println("Chuyên môn: " + listTeacher.get(i).getChuyenMon());
			System.out.println("*****************************************");
		}
	}

	public void displayStudentGetMostPoint() {
		System.out.println("Sinh viên có điểm cao nhất là " + listStudent.get(imaxPoint).getName().toUpperCase()
				+ " với " + maxPoint + " điểm");
		System.out.println("Sinh viên có điểm thấp nhất là " + listStudent.get(iminPoint).getName().toUpperCase()
				+ " với " + minPoint + " điểm");
	}

	public void displaySortStudentByPoint() {
		Collections.sort(listStudent, new StudentSort());
		flagSorted = true;
		displayStudent();
	}

	public void displayCourse() {
		System.out.println("*-----display course-----*".toUpperCase());
		System.out.println("Course name: " + course.getCourseName());
		System.out.println("Have " + course.getNumberOfStudent() + " students in course");
		System.out.println("Have " + course.getNumberOfTeacher() + " teachers in course");
	}
}