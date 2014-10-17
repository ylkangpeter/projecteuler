package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P14 {
	// private static HashSet<Long> gab = new HashSet<Long>();

	private static List<Long> resultL = new ArrayList<Long>();
	private static List<Long> l = new ArrayList<Long>();

	private static int a = 0;
	
	public static void main(String[] args) {
		int scale = 1000000;
		int result = 10;

		for (int i = scale - 1; i > 0; i--) {
			// if (gab.contains(i)) {
			// continue;
			// }

			HashSet<Long> set = new HashSet<Long>();
			calc(set, i);
			if (set.size() > result) {
				result = set.size();
				resultL.addAll(l);
				a=i;
			}
			l.clear();
			System.out.println(a);
			System.out.println(i);
		}
		// for (Long val : resultL) {
		// System.out.println(val);
		// }
		// System.out.println(result);
	}

	private static void calc(HashSet<Long> set, long i) {
		if (set.contains(i) || i == 1) {
			return;
		}
		// gab.add(i);
		l.add(i);
		set.add(i);
		if (i % 2 == 0) {
			calc(set, i / 2);
		} else {
			calc(set, 3 * i + 1);
		}

	}
}
