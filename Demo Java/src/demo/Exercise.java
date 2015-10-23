package demo;

public class Exercise {
	public static int foo = 1;

	public static void main(String[] args) {
		// foo+"Bar"
		String foo = "#";
		if ("#Bar".equals(Exercise.foo == 1 ? foo + "Bar" : foo))
			System.out.println("assertion#Bar");
		foo = "_";
		if ("_Bar".equals(Exercise.foo == 1 ? foo + "Bar" : foo))
			System.out.println("assertion_Bar");
		foo = "Bar";
		if ("BarBar".equals(Exercise.foo == 1 ? foo + "Bar" : foo))
			System.out.println("assertionBarBar");
	}
}
