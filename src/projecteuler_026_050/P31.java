package projecteuler_026_050;

public class P31 {

	public static void main(String[] args) {
		long total = 0;

		// 1
		for (int _1 = 0; _1 <= 200; _1++) {
			// 2
			for (int _2 = 0; _2 <= (200 - _1) / 2; _2++) {
				// 5
				for (int _5 = 0; _5 <= (200 - _1 - 2 * _2) / 5; _5++) {
					// 10
					for (int _10 = 0; _10 <= 20; _10++) {
						// 20
						for (int _20 = 0; _20 <= 10; _20++) {
							// 50
							for (int _50 = 0; _50 <= 4; _50++) {
								// 100
								for (int _100 = 0; _100 <= 2; _100++) {
									// 200
									for (int _200 = 0; _200 <= 1; _200++) {
										if (1 * _1 + 2 * _2 + 5 * _5 + 10 * _10
												+ 20 * _20 + 50 * _50 + 100
												* _100 + 200 * _200 == 200) {
											total++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(total);
	}
}
