package lec3.BasicOOP;

public class Subject {
	private String subjectID, subjectName;
	private int quota, currentEnrolment;

	public Subject() {
		this.quota = 0;
		this.currentEnrolment = 0;
	}

	public Subject(String initID, String initName, int initQuota, int initCurrentEnrolment) {
		this.subjectID = new String(initID);
		this.subjectName = new String(initName);
		this.quota = initQuota;
		this.currentEnrolment = initCurrentEnrolment;
	}

	public void enrolStudent() {
		System.out.print("Enrolling student... ");
		if (currentEnrolment < quota) {
			++currentEnrolment;
			System.out.println("Student enrolled in " + subjectName.toUpperCase());
		} else
			System.out.println("Quota reached, enrolment failed!");
	}

	public void unEnrolStudent() {
		System.out.print("Un-enrolling student... ");
		if (currentEnrolment <= 0)
			System.out.println("No students to un-enrol");
		else {
			--currentEnrolment;
			System.out.println("Student un-enrolled from " + subjectName.toUpperCase());
		}
	}

	public void displaySubjectInfo() {
		System.out.println("Subject name: " + subjectName.toUpperCase());
		System.out.println("Subject ID: " + subjectID);
		System.out.println("Quota: " + quota);
		System.out.println("Currently enrolled: " + currentEnrolment);
		int availablePlaces = quota - currentEnrolment;
		System.out.println("Can accept " + availablePlaces + " more students");
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
