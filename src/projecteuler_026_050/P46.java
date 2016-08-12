package projecteuler_026_050;

import java.util.Set;

import util.Util;

public class P46 {
	public static void main(String[] args) {
		long i = 2;
		while (true) {
			i++;
			if (i % 2 == 0 || Util.isPrime(i)) {
				continue;
			}
			Set<Long> set = Util.genPrimeNumberBelow(i);
			boolean isQualified = false;
			for (Long val : set) {
				long num = (i - val) / 2;
				if (Math.sqrt(num) % 1 == 0) {
					isQualified = true;
					break;
				}
			}
			if (!isQualified) {
				System.out.println(i);
				break;
			}
		}
	}
}
