package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class P3 {

	private static List<Integer> primeList = new ArrayList<Integer>();

	private static long maxPrime = (long) Math.sqrt(600851475143L) + 1;

	public static void main(String[] args) {
		for (int i = 2; i < maxPrime; i++) {
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(i) + 1; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeList.add(i);
			}
		}

		int max = 1;
		for (Integer prime : primeList) {
			if (600851475143L % prime == 0) {
				max = prime;
			}
		}
		System.out.println(max);
	}

}
