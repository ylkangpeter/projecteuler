package projecteuler_051_100;

import java.math.BigInteger;

public class P53 {

	public static void main(String[] args) {
		long counter = 0;
		// TODO consider odd & even number c3/5 = c2/5
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (r == n || r == 1) {
					continue;
				}
				BigInteger divider = factorial2(
						new BigInteger(String.valueOf(n)), new BigInteger(
								String.valueOf(n - r + 1)));
				BigInteger denominator = factorial(new BigInteger(
						String.valueOf(r)));
				if (divider.divide(denominator).compareTo(
						BigInteger.valueOf(1000000)) > 0) {
					System.out.println(r + " " + n);
					counter++;
				}
			}
		}
		System.out.println(counter);
	}

	private static BigInteger factorial(BigInteger bi) {
		if (bi.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return bi.multiply(factorial(bi.subtract(BigInteger.ONE)));
	}

	private static BigInteger factorial2(BigInteger bi, BigInteger end) {
		if (end.equals(BigInteger.ONE)) {
			return bi;
		}
		if (bi.equals(end)) {
			return end;
		}
		return bi.multiply(factorial2(bi.subtract(BigInteger.ONE), end));
	}
}
