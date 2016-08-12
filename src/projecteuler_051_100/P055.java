package projecteuler_051_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Util;

public class P055 {

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 1; i < 10000; i++) {
			int j = 0;
			List<Integer> list = Util.getListFormInt(String.valueOf(i));
			boolean isFound = false;
			while (j++ < 50 && !isFound) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(list);
				Collections.reverse(tmp);
				list = Util.add(list, tmp);
				isFound = true;
				for (int k = 0; k < (list.size() / 2 + 1); k++) {
					if (list.get(k) == list.get(list.size() - k - 1)) {
						continue;
					}
					isFound = false;
					break;
				}
			}
			if (!isFound) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
