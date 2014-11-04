package projecteuler_026_050;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class P48 {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		BigInteger sum = BigInteger.ZERO;
		BigInteger temp = BigInteger.ONE;
		BigInteger GrandTotal = BigInteger.ZERO;

		for (int i = 1; i <= 20; i++) {

		}

		long end = System.currentTimeMillis();

		System.out.println(GrandTotal);
		System.out.println(end - begin + "ms");

		// ====================================

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);

		for (int j = 1; j < 1000; j++) {
			sum = temp.pow(j);
			temp = temp.add(BigInteger.ONE);
			GrandTotal = GrandTotal.add(sum);

			if (j % 10 == 0)
				continue;
			List<Integer> ll = new ArrayList<Integer>();
			ll.add(j);
			String num = j + "";
			List<Integer> l = new ArrayList<Integer>();
			for (int k = num.length() - 1; k >= 0; k--) {
				l.add(Character.getNumericValue(num.charAt(k)));
			}
			for (int i = 1; i < j; i++) {
				ll = Util.multi(ll, l);
				if (ll.size() > 10) {
					ll = ll.subList(0, 11);
				}
			}
			list = Util.add(list, ll);
			BigInteger b = BigInteger.ZERO;
			for (int i = 0; i < list.size(); i++) {
				b = b.add(BigInteger.valueOf((long) (Math.pow(10, i) * list
						.get(i))));
			}
			if (!GrandTotal.subtract(b)
					.mod(BigInteger.valueOf((long) Math.pow(10, 10)))
					.equals(BigInteger.ZERO)) {
				break;
			}
		}
		for (int i = 9; i >= 0; i--) {
			System.out.print(list.get(i));
		}
	}
}
