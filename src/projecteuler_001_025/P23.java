package projecteuler_001_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import util.Util;

public class P23 {

	public static void main(String[] args) {
		long total = 0;
		for (int i = 1; i <= 28123; i++) {
			total += i;
		}
		List<Integer> ll = getAbundantNumber(28123);
		Collections.sort(ll);
		int smallest = ll.get(0);
		int largestInx = Collections.binarySearch(ll, 28123 - smallest);
		if (largestInx < 0) {
			largestInx = -largestInx - 1;
		}
		ll = ll.subList(0, largestInx + 1);
		Set<Integer> deleted = new HashSet<Integer>();
		for (Iterator<Integer> iterator = ll.iterator(); iterator.hasNext();) {
			Integer val = iterator.next();
			for (Integer ele : ll) {
				if (ele + val <= 28123 && !deleted.contains(ele + val)) {
					total = total - ele - val;
					deleted.add(ele + val);
				}
			}
			iterator.remove();

		}

		System.out.println(total);
	}

	public static Set<Integer> combs(Set<Integer> set) {
		Set<Integer> result = new HashSet<Integer>();
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			Integer val = iterator.next();
			iterator.remove();
			for (Integer ele : set) {
				result.add(ele + val);
			}

		}
		return result;
	}

	public static List<Integer> getAbundantNumber(int upper) {
		List<Integer> set = new ArrayList<Integer>();
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
