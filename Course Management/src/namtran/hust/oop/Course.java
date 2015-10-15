package namtran.hust.oop;

import java.util.ArrayList;

public class Course {
	private String courseName;
	private int numberOfStudent;
	private int numberOfTeacher;
	private ArrayList<Student> listStudent;
	private ArrayList<Teacher> listTeacher;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getNumberOfStudent() {
		numberOfStudent = listStudent.size();
		return numberOfStudent;
	}

	public int getNumberOfTeacher() {
		numberOfTeacher = listTeacher.size();
		return numberOfTeacher;
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public ArrayList<Teacher> getListTeacher() {
		return listTeacher;
	}

	public void setListTeacher(ArrayList<Teacher> listTeacher) {
		this.listTeacher = listTeacher;
	}

}
