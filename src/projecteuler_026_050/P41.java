package projecteuler_026_050;

import java.util.HashSet;
import java.util.Set;

import util.Util;

public class P41 {

	/**
	 * 9+8+7+6+5+4+3+2+1 = 45, 8+7+6+5+4+3+2+1 = 36, 6+5+4+3+2+1 = 21, and
	 * 5+4+3+2+1 = 15, all of which are divisible by 3 and therefore could not
	 * yield a 1 to {5, 6, 8, 9} pandigital prime. So that leaves 4 and 7 digit
	 * prime numbers less than 4321 and 7654321 respectively. Since we want the
	 * largest pandigital prime we’ll check the 7 digit group first.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long num = 7777777;
		while (num > 3) {
			num = Util.genNextDescPrimeNumber(num, "");
			String str = String.valueOf(num);
			Set<Character> s = new HashSet<Character>();
			for (int i = 1; i < str.length() + 1; i++) {
				s.add(Character.forDigit(i, 10));
			}
			for (char c : str.toCharArray()) {
				s.remove(c);
			}
			if (s.isEmpty()) {
				System.out.println(num);
				break;
			}
		}
	}
}
