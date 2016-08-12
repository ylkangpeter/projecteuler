package projecteuler_051_100;

import java.util.Set;

import util.Util;

public class P51 {

	public static void main(String[] args) {
		long num = 100000;
		Set<Long> set = Util.genPrimeNumberBelow(1000000);
		while (num < 1000000) {
			int counter = 0;
			String tmp = String.valueOf(num);
			if (set.contains(tmp)) {
				counter++;
			}
			if (set.contains(tmp + 11100)) {
				counter++;
			}
			if (set.contains(tmp + 22200)) {
				counter++;
			}
			if (set.contains(tmp + 33300)) {
				counter++;
			}
			if (set.contains(tmp + 44400)) {
				counter++;
			}
			if (set.contains(tmp + 55500)) {
				counter++;
			}
			if (set.contains(tmp + 66600)) {
				counter++;
			}
			if (set.contains(tmp + 77700)) {
				counter++;
			}
			if (set.contains(tmp + 88800)) {
				counter++;
			}
			if (set.contains(tmp + 99900)) {
				counter++;
			}
			if (counter == 8) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}
