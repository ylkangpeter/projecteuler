package projecteuler_001_025;

public class P5 {

	public static void main(String[] args) {
		long value = 1;
		for (int i = 2; i <= 20; i++) {
			value = scm(i, value);
		}
		System.out.println(value);
	}

	private static long lcd(long a, long b) {
		long large = a > b ? a : b;
		long small = a > b ? b : a;
		if (large % small == 0) {
			return small;
		} else {
			return lcd(large % small, small);
		}

	}

	private static long scm(long a, long b) {
		return a * b / lcd(a, b);
	}
}
