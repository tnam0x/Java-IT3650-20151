package demo;

class Test {
	private static char c;
	public static void main(String[] args) {
		Test t = new Test();
		t.display();
		if(c==0)
			System.out.println("0");
	}
	public void display() {
		System.out.println(c);
	}
}
