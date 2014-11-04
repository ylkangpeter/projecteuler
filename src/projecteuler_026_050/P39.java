package projecteuler_026_050;


public class P39 {

	public static void main(String[] args) {
		int result = 0;
		int times = 0;
		for (int i = 121; i <= 1000; i++) {
			int total = 0;
			for (int a = 1; a < i / 3; a++) {
				for (int b = i / 3; b < i; b++) {
					int c = i - a - b;
					if (c <= 0) {
						continue;
					}
					if (c > b) {
						continue;
						// if (c * c == a * a + b * b) {
						// System.out.println(String.format("%d %d %d", a, b,
						// c));
						// total++;
						// }
					} else {
						if (b * b == a * a + c * c) {
							System.out.println(String.format("%d %d %d", a, b,
									c));
							total++;
						}
					}
				}
			}
			if (total > times) {
				times = total;
				result = i;
			}
			System.out.println("------------");
		}
		System.out.println(result);
	}
}
