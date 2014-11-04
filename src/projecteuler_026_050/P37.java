package projecteuler_026_050;

import util.Util;

public class P37 {

	public static void main(String[] args) {
		int number = 0;
		long total = 0;
		long seed = 22;
		while (number <= 13) {
			long n = Util.genNextPrimeNumber(seed, "02468");
			seed = n;
			if (isTruncablePrime(n, (n + "").length())) {
				total += n;
				System.out.println(n);
				number++;
			}

		}
		System.out.println(total);
	}

	private static boolean isTruncablePrime(long n, int len) {
		if (len == 0) {
			return true;
		}
		if (!Util.isPrime(n)) {
			return false;
		}
		for (int i = 1; i < len; i++) {
			if (!Util.isPrime(n % (long) Math.pow(10, i))) {
				return false;
			}
			if (!Util.isPrime(n / (long) Math.pow(10, i))) {
				return false;
			}
		}
		return true;
	}
}
