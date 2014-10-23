package projecteuler_026_050;

import java.util.ArrayList;
import java.util.List;

public class P26 {

	public static void main(String[] args) {
		int max = 0;
		int result = 0;
		for (int i = 3; i < 1000; i++) {
			List<Integer> list = new ArrayList<Integer>();
			int j = 1;
			while (!list.contains(j) && j != 0) {
				list.add(j);
				while (j < i) {
					j *= 10;
				}
				j = j % i;
			}
			if (list.size() > max && j != 0) {
				max = list.size();
				result = i;
			}
		}
		System.out.println(result);
	}
}
