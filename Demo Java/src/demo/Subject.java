package demo;

public class Subject {
	private String subjectName, subjectID;
	private int quota, currentEnrolment;

	public Subject() {
		this.quota = 0;
		this.currentEnrolment = 0;
	}

	public Subject(String subjectName, String subjectID, int quota, int currentEnrolment) {
		this.subjectName = subjectName;
		this.subjectID = subjectID;
		this.quota = quota;
		this.currentEnrolment = currentEnrolment;
	}

	public void enrolStudent() {
		System.out.print("Enrolment student... ");
		if (currentEnrolment < quota) {
			++currentEnrolment;
			System.out.println("Student enrolled in " + subjectName);
		} else
			System.out.println("Quota reached, enrolment failed!");
	}

	public void unEnrolStudent() {
		System.out.print("Unenrolment student... ");
		if (currentEnrolment <= 0)
			System.out.println("No student to unenrol!");
		else {
			--currentEnrolment;
			System.out.println("Student unenrolled from " + subjectName);
		}
	}

	public void displaySubjectInfo() {
		System.out.println("Subject Name: " + subjectName);
		System.out.println("Subject ID: " + subjectID);
		System.out.println("Quota: " + quota);
		System.out.println("Currently enrolled: " + currentEnrolment);
		System.out.println("Can accept " + (quota - currentEnrolment) + " more students");
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getCurrentEnrolment() {
		return currentEnrolment;
	}

	public void setCurrentEnrolment(int currentEnrolment) {
		this.currentEnrolment = currentEnrolment;
	}
}
