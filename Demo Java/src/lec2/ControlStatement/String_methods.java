package lec2.ControlStatement;

public class String_methods {
	public static void main(String[] args) {
		final String MY_NAME = "Trần Xuân Nam";

		System.out.println("charAt(): " + MY_NAME.charAt(5));
		System.out.println("length(): " + MY_NAME.length());
		System.out.println("toLowerCase: " + MY_NAME.toLowerCase());
		System.out.println("compareTo: " + MY_NAME.compareTo("trần"));
		System.out.println("concat: " + MY_NAME.concat(" 20122126"));
		System.out.println("indexOf: " + MY_NAME.indexOf(6));
	}
}
