package projecteuler_026_050;

import java.util.Set;

import util.Util;

public class P27 {

	public static void main(String[] args) {
		Set<Integer> primeSet = Util.genPrimeNumberBelow(2001000);
		Set<Integer> factorSet = Util.genPrimeNumberBelow(1000);

		int max = 0;
		int _a = 0;
		int _b = 0;
		for (Integer a : factorSet) {
			for (Integer b : factorSet) {
				int max1 = calc(primeSet, max, a, b);
				int max2 = calc(primeSet, max, -a, b);
				int max3 = calc(primeSet, max, a, -b);
				int max4 = calc(primeSet, max, -a, -b);
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

	private static int calc(Set<Integer> primeSet, int max, Integer a, Integer b) {
		int i = 0;
		while (true) {
			int number = i * i + a * i + b;
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
