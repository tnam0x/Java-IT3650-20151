package lec2.ControlStatement;

public class Continue_Outer {
	public static void main(String[] args) {
		int sum = 0;
		outer: for (int i = 0; i < 10; i++) {
			inner: for (int j = 0; j < 10; j++) {
				sum++;
				if (j == 1)
					continue;
				if (j == 2)
					continue outer;
				if (j == 3)
					break;
				if (j == 4)
					continue inner;
			}
		}
		System.out.println("Gia tri la: " + sum);
	}
}
