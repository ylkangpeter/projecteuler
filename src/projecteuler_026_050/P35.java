package projecteuler_026_050;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import projecteuler_001_025.P24_permutation;
import util.Util;

public class P35 {

	public static void main(String[] args) {
		Set<Integer> set = Util.genPrimeNumberBelow(1000000);
		Set<Integer> result = new HashSet<Integer>();
		int counter = 0;
		while (!set.isEmpty()) {
			if (counter % 100 == 0) {
				System.out.println(counter + "/" + set.size());
			}
			int i = set.iterator().next();
			counter++;
			String mm = i + "";
			if (mm.indexOf("0") >= 0 || mm.indexOf("2") >= 0
					|| mm.indexOf("4") >= 0 || mm.indexOf("6") >= 0
					|| mm.indexOf("8") >= 0 || mm.indexOf("5") >= 0) {
				set.remove(i);
				continue;
			}
			Set<Integer> tmp = gen(i);
			boolean isOk = true;
			for (Integer integer : tmp) {
				if (set.contains(integer)) {
					set.remove(integer);
					continue;
				}
				isOk = false;
			}
			if (isOk) {
				result.addAll(tmp);
				System.out.println("-------" + tmp.size());
			}
			set.remove(i);
		}
		for (Integer integer : result) {
			System.out.println(integer);
		}
		System.out.println(result.size() + 2/* 2&5 */);

	}

	private static Set<Integer> gen(int i) {
		Set<Integer> result = new HashSet<Integer>();
		char[] cc = (i + "").toCharArray();
		int[] t = new int[cc.length];

		for (int j = 0; j < t.length; j++) {
			t[j] = Character.getNumericValue(cc[j]);
		}
		Arrays.sort(t);
		try {
			while (true) {
				int num = 0;
				for (int c = 0; c < t.length; c++) {
					num += t[c] * Math.pow(10, c);
				}
				result.add(num);
				P24_permutation.genNext(t);
			}
		} catch (Exception e) {
		}
		return result;
	}
}
