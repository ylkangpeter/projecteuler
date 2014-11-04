package projecteuler_026_050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import util.Util;

public class P50 {

	public static void main(String[] args) {
		Set<Integer> primeSet = Util.genPrimeNumberBelow(1000000);
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(primeSet);
		Collections.sort(list);
		int maxLen = 1;
		int maxTotal = 0;
		for (int i = 0; i < list.size(); i++) {
			int len = 1;
			int total = list.get(i);
			int value = 0;
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
