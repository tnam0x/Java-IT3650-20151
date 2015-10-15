package namtran.hust.oop;

public class Subject {
	private String subjectName;
	private int id;

	public void displaySubject() {
		System.out.println("Subject name: " + subjectName);
		System.out.println("Subject id: " + id);
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
