package projecteuler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class P23 {

	public static void main(String[] args) {
		Set<Integer> set = getAbundantNumber(28123);
		Set<Integer> allCombs = combs(set);
		long total = 0;
		for (int i = 1; i <= 28123; i++) {
			if (!allCombs.contains(i)) {
				total += i;
			}
		}
		System.out.println(total);
	}

	// private static Set<Integer> combs(Set<Integer> set) {
	// Set<Integer> result = new HashSet<Integer>();
	// for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
	// Integer val = iterator.next();
	// iterator.remove();
	// for (Integer ele : set) {
	// result.add(ele + val);
	// }
	//
	// }
	// return result;
	// }

	public static Set<Integer> getAbundantNumber(int upper) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < upper; i++) {
			List<Integer> l = Util.getDivider(i, false);
			int val = 0;
			for (Integer integer : l) {
				val += integer;
			}
			if (val > i) {
				set.add(i);
			}
		}
		return set;
	}
}
