package demo;

public class SubjectManagement {
	public static void main(String[] args) {
		Subject javaPrograming = new Subject("IT3650", "Java Programing", 40, 0);
		javaPrograming.unEnrolStudent();
		javaPrograming.displaySubjectInfo();
		System.out.println();

		for (int i = 1; i <= 40; i++)
			javaPrograming.enrolStudent();
		javaPrograming.displaySubjectInfo();

		System.out.println();
		javaPrograming.enrolStudent();
		javaPrograming.displaySubjectInfo();
	}
}
