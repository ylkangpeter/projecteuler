package projecteuler;

public class P7 {

	public static void main(String[] args) {

		int i = 2;
		int counter = 0;
		while (true) {
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(i) + 1; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				counter++;
				System.out.println(i);
				if (counter > 10000) {
					System.out.println(i);
					break;
				}
			}
			i++;
		}

	}

}
