package namtran.exam.middle;

import java.util.Comparator;

public class StudentSort implements Comparator<Student>{
	public int compare(Student student1, Student student2) {
		float point1 = student1.getPoint();
		float point2 = student2.getPoint();
		
		if (point1 > point2)
			return -1;
		else if (point1 == point2)
			return 0;
		else
			return 1;
	}
}
