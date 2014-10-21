package projecteuler;

import java.util.ArrayList;
import java.util.List;

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
