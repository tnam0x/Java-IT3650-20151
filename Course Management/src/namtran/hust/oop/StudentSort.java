package namtran.hust.oop;

import java.util.Comparator;

public class StudentSort implements Comparator<Student> {
	public int compare(Student student1, Student student2) {
		int point1 = student1.getDiemMonHoc();
		int point2 = student2.getDiemMonHoc();
		
		if (point1 > point2)
			return -1;
		else if (point1 == point2)
			return 0;
		else
			return 1;
	}
}
