package projecteuler_026_050;

import java.util.Set;

import util.Util;

public class P27 {

	public static void main(String[] args) {
		Set<Long> primeSet = Util.genPrimeNumberBelow(2001000);
		Set<Long> factorSet = Util.genPrimeNumberBelow(1000);

		long max = 0;
		long _a = 0;
		long _b = 0;
		for (Long a : factorSet) {
			for (Long b : factorSet) {
				long max1 = calc(primeSet, max, a, b);
				long max2 = calc(primeSet, max, -a, b);
				long max3 = calc(primeSet, max, a, -b);
				long max4 = calc(primeSet, max, -a, -b);
				if (max1 > max) {
					max = max1;
					_a = a;
					_b = b;
				}
				if (max2 > max) {
					max = max2;
					_a = -a;
					_b = b;
				}
				if (max3 > max) {
					max = max3;
					_a = a;
					_b = -b;
				}
				if (max4 > max) {
					max = max4;
					_a = -a;
					_b = -b;
				}
			}
		}
		System.out.println(_a * _b);
	}

	private static long calc(Set<Long> primeSet, long max, long a, long b) {
		long i = 0;
		while (true) {
			long number = i * i + a * i + b;
			if (primeSet.contains(number)) {
				i++;
				continue;
			}
			break;
		}
		max = i > max ? i : max;
		return max;
	}
}
