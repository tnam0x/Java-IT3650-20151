package demo;

public class SomeElse {
	public static int Foo = 10;

	public static void main(String[] args) {
		/*if ((Foo++ == 10 ? 100 : (Foo == 12 ? 1 : -13)) == 100)
			System.out.println("Y");
		if ((Foo++ == 10 ? 100 : (Foo == 12 ? 1 : -13)) == 1)
			System.out.println("Y");
		if ((Foo++ == 10 ? 100 : (Foo == 12 ? 1 : -13)) == -13)
			System.out.println("Y");*/
		
		/*float f = 0f/0f;
		if(f!=f)
			System.out.println("Y");*/
		
		// (int) Float.MAX_VALUE;
		// (int) Math.pow(2, 31) - 2; // lợi dụng tràn số
		// -1>>>1
		int f = (int) (Math.pow(2, 31) - 1);
		System.out.println(f == Integer.MAX_VALUE);
		
	}
}
