package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {

	public static int[] genPrimeNumber(int len) {
		int[] result = new int[len];
		int counter = 0;
		int number = 2;
		while (counter < len) {
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(number) + 1; j++) {
				if (number % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				result[counter] = number;
				counter++;
				number++;
			}
		}
		return result;
	}

	public static Set<Integer> genPrimeNumberBelow(int max) {
		Set<Integer> set = new HashSet<Integer>();
		int number = 2;
		while (number < max) {
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(number) + 1; j++) {
				if (number % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				set.add(number);
			}
			number++;
			// if (number % 1000 == 0)
			// System.out.println(number);
		}
		return set;
	}

	// public static int[] fibonacci(int len) {
	// int[]
	// }

	public static int fibonacci(int position) {
		if (position == 2) {
			return 1;
		} else if (position == 1) {
			return 1;
		} else {
			return fibonacci(position - 1) + fibonacci(position - 2);
		}
	}

	public static List<Integer> getDivider(int num, boolean includeSelf) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i < num / 2 + 1; i++) {
			if (num % i == 0) {
				l.add(i);
			}
		}
		if (includeSelf) {
			l.add(num);
		}
		return l;
	}
}
