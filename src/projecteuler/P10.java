package projecteuler;

public class P10 {

	public static void main(String[] args) {

		int i = 2;
		long total = 0;
		while (i < 2000000) {
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(i) + 1; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				total += i;
				// System.out.println(i);
			}
			i++;
		}
		System.out.println(total);
	}

}
