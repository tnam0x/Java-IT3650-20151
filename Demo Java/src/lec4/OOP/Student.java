package lec4.OOP;

public class Student {
	private String name;
	private int age;
	private String profession;
	private String university;
	private int credits;

	public Student(String initName, int initAge, String initUniversity) {
		this.name = initName;
		this.age = initAge;
		this.profession = "Student";
		this.university = initUniversity;
		this.credits = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + "   " + this.age + "   " + this.university + "   " + this.profession + "   "
				+ this.credits);
		return sb.toString();
	}
}
