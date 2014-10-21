package projecteuler;

import java.util.HashSet;
import java.util.Set;

public class P21 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();

		long total = 0;
		for (int i = 1; i <= 10000; i++) {
			if (set.contains(i)) {
				continue;
			}
			int v = calc(i);
			if (v == i) {
				set.add(i);
				continue;
			}
			if (calc(v) == i) {
				total += v;
				total += i;
				set.add(v);
			}
		}
		System.out.println(total);
	}

	private static int calc(int val) {
		int total = 0;
		for (int i = 1; i < val / 2 + 1; i++) {
			if (val % i == 0) {
				total += i;
			}
		}
		return total;
	}
}
