package projecteuler_026_050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import util.Util;

public class P50 {

	public static void main(String[] args) {
		Set<Long> primeSet = Util.genPrimeNumberBelow(1000000);
		List<Long> list = new ArrayList<Long>();
		list.addAll(primeSet);
		Collections.sort(list);
		int maxLen = 1;
		long maxTotal = 0;
		for (int i = 0; i < list.size(); i++) {
			int len = 1;
			long total = list.get(i);
			long value = 0;
			for (int j = i + 1; j < list.size() && total < 1000000; j++) {
				total += list.get(j);
				if (primeSet.contains(total)) {
					len = j - i + 1;
					value = total;
				}
			}
			if (len > maxLen) {
				maxLen = len;
				maxTotal = value;
				System.out.println(list.get(i));
			}
		}
		System.out.println(maxLen + " " + maxTotal);
	}
}
