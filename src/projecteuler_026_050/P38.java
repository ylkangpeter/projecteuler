package projecteuler_026_050;

import java.util.HashSet;
import java.util.Set;

public class P38 {

	public static void main(String[] args) {
		int number = 0;
		for (int i = 9876; i >= 5123; i--) {
			int _1 = i;
			int _2 = 2 * i;
			if (("" + _1 + _2).length() != 9)
				continue;
			Set<Character> set = new HashSet<Character>();
			for (char c : ("" + _1 + _2).toCharArray()) {
				if (c == '0') {
					continue;
				}
				set.add(c);
			}
			if (set.size() == 9) {
				number = i;
				break;
			}
		}
		// for (int i = 123; i <= 5123; i--) {
		// int _1 = i;
		// int _2 = 2 * i;
		// int total = 0;
		// if (("" + _1 + _2).length() != 9)
		// continue;
		// for (char c : ("" + _1 + _2).toCharArray()) {
		// total += Character.getNumericValue(c);
		// }
		// if (total == 45) {
		// isFind = true;
		// number = i;
		// break;
		// }
		// }
		System.out.println(number);
	}
}
