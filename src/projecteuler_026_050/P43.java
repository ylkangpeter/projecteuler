package projecteuler_026_050;

import util.Util;

public class P43 {

	public static void main(String[] args) {
		long total = 0;
		int[] arr = new int[10];
		arr[0] = 1;
		arr[1] = 0;
		for (int i = 2; i < 10; i++) {
			arr[i] = i;
		}
		while (true) {
			try {
				if ((arr[1] * 100 + arr[2] * 10 + arr[3]) % 2 == 0) {
					if ((arr[2] * 100 + arr[3] * 10 + arr[4]) % 3 == 0) {
						if ((arr[3] * 100 + arr[4] * 10 + arr[5]) % 5 == 0) {
							if ((arr[4] * 100 + arr[5] * 10 + arr[6]) % 7 == 0) {
								if ((arr[5] * 100 + arr[6] * 10 + arr[7]) % 11 == 0) {
									if ((arr[6] * 100 + arr[7] * 10 + arr[8]) % 13 == 0) {
										if ((arr[7] * 100 + arr[8] * 10 + arr[9]) % 17 == 0) {
											total = total
													+ Util.getNormalFormInt(arr);
										}
									}
								}
							}
						}
					}
				}
				Util.genNextPerm(arr);
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(total);
	}
}
