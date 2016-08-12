package projecteuler_026_050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Util;

public class P35 {

	public static void main(String[] args) {
		Set<Long> set = Util.genPrimeNumberBelow(1000000);
		List<Long> newList = new ArrayList<Long>();
		for (Long i : set) {
			String mm = i + "";
			if (mm.indexOf("0") >= 0 || mm.indexOf("2") >= 0
					|| mm.indexOf("4") >= 0 || mm.indexOf("6") >= 0
					|| mm.indexOf("8") >= 0 || mm.indexOf("5") >= 0) {
				continue;
			}
			newList.add(i);
		}
		Collections.sort(newList);
		Set<Long> result = new HashSet<Long>();

		for (Long i : newList) {
			Set<Long> tmp = gen(i);

			boolean isOk = true;
			for (Long integer : tmp) {
				if (set.contains(integer)) {
					continue;
				}
				isOk = false;
			}
			if (isOk) {
				result.addAll(tmp);
				System.out.println("-------" + tmp.size());
			}
		}

		for (Long integer : result) {
			System.out.println(integer);
		}
		System.out.println(result.size() + 2/* 2&5 */);

	}

	private static Set<Long> gen(long i) {
		Set<Long> result = new HashSet<Long>();
		if (i < 10) {
			result.add(i);
			return result;
		}
		char[] cc = (i + "").toCharArray();
		for (int j = 0; j < cc.length; j++) {
			i = (int) (i % Math.pow(10, cc.length - 1) * 10 + i
					/ Math.pow(10, cc.length - 1));
			result.add(i);
		}
		return result;
	}
	// private static Set<Integer> gen(int i) {
	// Set<Integer> result = new HashSet<Integer>();
	// char[] cc = (i + "").toCharArray();
	// int[] t = new int[cc.length];
	//
	// for (int j = 0; j < t.length; j++) {
	// t[j] = Character.getNumericValue(cc[j]);
	// }
	// Arrays.sort(t);
	// try {
	// while (true) {
	// int num = 0;
	// for (int c = 0; c < t.length; c++) {
	// num += t[c] * Math.pow(10, c);
	// }
	// result.add(num);
	// P24_permutation.genNext(t);
	// }
	// } catch (Exception e) {
	// }
	// return result;
	// }
}
