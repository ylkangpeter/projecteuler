package projecteuler_026_050;

import java.util.HashSet;
import java.util.Set;

public class P44 {
	private static final Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		int i = 0;
		boolean isContinue = true;
		while (isContinue) {
			i++;
			int p = (3 * i * i - i) / 2;
			set.add(p);
			for (Integer a : set) {
				if (set.contains(p - a) && set.contains(p - 2 * a)) {
					System.out.println(p - 2 * a);
					isContinue = false;
					break;
				}
			}
		}
	}
}
