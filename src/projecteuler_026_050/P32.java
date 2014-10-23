package projecteuler_026_050;

import java.util.HashSet;
import java.util.Set;

import projecteuler_001_025.P24_permutation;

public class P32 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Set<Integer> set = new HashSet<Integer>();

		while (true) {
			try {
				// 1,4,4
				int a = arr[0];
				int b = arr[1] * 1000 + arr[2] * 100 + arr[3] * 10 + arr[4];
				int c = arr[5] * 1000 + arr[6] * 100 + arr[7] * 10 + arr[8];
				if (a * b == c) {
					set.add(c);
				}
				// 2,3,4
				a = arr[0] * 10 + arr[1];
				b = arr[2] * 100 + arr[3] * 10 + arr[4];
				c = arr[5] * 1000 + arr[6] * 100 + arr[7] * 10 + arr[8];
				if (a * b == c) {
					set.add(c);
				}
				P24_permutation.genNext(arr);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

		long result = 0;
		for (Integer integer : set) {
			result += integer;
		}
		System.out.println(result);
	}
}
