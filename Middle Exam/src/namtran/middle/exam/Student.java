package namtran.middle.exam;

import java.util.Scanner;

public class Student {
	private String name;
	private String id;
	private String code;
	private String title;
	private final int[] heSo = { 10, 30, 60 };
	private float point;
	private static Scanner sc;

	public Student() {
		this.code = "IT3650";
		this.title = "Database programing";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint() {
		float point1, point2, point3;
		sc = new Scanner(System.in);
		System.out.println("Enter point: ");
		System.out.print("\tpoint 1: ");
		point1 = sc.nextInt();
		System.out.print("\tpoint 2: ");
		point2 = sc.nextInt();
		System.out.print("\tpoint 3: ");
		point3 = sc.nextInt();
		this.point = (point1 * heSo[0] + point2 * heSo[1] + point3 * heSo[2]) / 100;
	}
}
