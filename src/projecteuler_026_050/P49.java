package projecteuler_026_050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import util.Util;

public class P49 {

	public static void main(String[] args) {

		Set<Long> primeSet = Util.genPrimeNumberBelow(9999);
		for (Iterator<Long> iterator = primeSet.iterator(); iterator.hasNext();) {
			Long val = (Long) iterator.next();
			if (val < 1000) {
				iterator.remove();
			}
		}
		while (!primeSet.isEmpty()) {
			String val = primeSet.iterator().next().toString();
			Set<List<Integer>> permList = Util.genPermutation(Util
					.getListFormInt(val));
			List<Integer> list = new ArrayList<Integer>();
			for (List<Integer> l : permList) {
				int tmp = Util.getNormalFormInt(l);
				if (primeSet.contains(tmp)) {
					list.add(tmp);
				}
			}
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			});
			// calc
			boolean isFound = false;
			for (int i = 0; i < list.size() - 1 && !isFound; i++) {
				int start = list.get(i);
				int last = list.get(i + 1);
				int gap = last - start;

				for (int j = i + 2; j < list.size(); j++) {
					int gap2 = list.get(j) - last;
					if (gap2 == gap) {
						System.out.println(start + " " + (start + gap) + " "
								+ (start + 2 * gap));
						isFound = true;
						break;
					} else if (gap2 > gap) {
						last = list.get(j);
						gap = last - start;
					}
				}
			}
			for (Integer i : list) {
				primeSet.remove(i);
			}
		}
	}
}
