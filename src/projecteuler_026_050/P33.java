package projecteuler_026_050;

import java.util.ArrayList;
import java.util.List;

public class P33 {

	public static void main(String[] args) {
		// ab/bc = a/c -> 9ac+bc=10ab
		// ba/cb = a/c -> 9ac+ab=10bc
		List<Integer> numerator = new ArrayList<Integer>();
		List<Integer> denominator = new ArrayList<Integer>();

		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 10; b++) {
				if (a == b) {
					continue;
				}
				for (int c = 1; c < 10; c++) {
					if (c < a) {
						continue;
					}
					if (9 * a * c + b * c == 10 * a * b) {
						numerator.add(a);
						denominator.add(c);
						System.out.print(10 * a + b + "/");
						System.out.print(10 * b + c + " ");
						System.out.println(a + "/" + c);
					}
					if (9 * a * c + b * a == 10 * c * b) {
						numerator.add(a);
						denominator.add(c);
						System.out.print(10 * b + a + "/");
						System.out.print(10 * c + b + " ");
						System.out.println(a + "/" + c);
					}
				}
			}
		}
		int num = 1;
		int den = 1;
		for (int i = 0; i < numerator.size(); i++) {
			num *= numerator.get(i);
			den *= denominator.get(i);
		}
		System.out.println(num + " " + den);
	}
}
