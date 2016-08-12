package projecteuler_001_025;

import util.Util;

/**
 * 
 * 01432
 * 
 * <pre>
 * 1. find 1st increasing pair: 14
 * 2. mark 1, find smallest number after 1: 432 -> 2
 * 3. swap 1,2 -> 02431
 * 4. reverse 431 -> 02134
 * </pre>
 * 
 * @author ylkang Oct 22, 2014
 */

public class P24_permutation {

	public static void main(String[] args) throws Exception {
		int upperBorder = 1000000;
		int noForEachCap = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
		int finalCap = 0;
		int total = 0;
		for (finalCap = 0; finalCap < 10; finalCap++) {
			total += noForEachCap;
			if (total > upperBorder) {
				break;
			}
		}
		total -= noForEachCap;
		System.out.println(finalCap);

		int[] init = { 2, 0, 1, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = total + 1; i < 1000000; i++) {
			Util.genNextPerm(init);
		}
		for (int i = 0; i < init.length; i++) {
			System.out.print(init[i]);
		}

	}

}
