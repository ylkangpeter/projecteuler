package projecteuler;

public class P9 {

	private static final int total = 1000;

	public static void main(String[] args) {

		for (int i = 1; i < 998; i++) {
			for (int j = i; i + j < 998; j++) {
				long k = total - i - j;
				long a = i;
				long max, b;
				if (j > k) {
					max = j;
					b = k;
				} else {
					max = k;
					b = j;
				}
				if (max * max == a * a + b * b) {
					System.out.println(a + " " + b + " " + max);
					System.out.println(a * b * max);
					break;
				}

			}
		}
	}
}
