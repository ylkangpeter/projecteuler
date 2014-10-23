package projecteuler_026_050;

public class P30 {

	public static void main(String[] args) {
		long total = 0;
		for (int _0 = 0; _0 < 10; _0++) {
			for (int _1 = 0; _1 < 10; _1++) {
				for (int _2 = 0; _2 < 10; _2++) {
					for (int _3 = 0; _3 < 10; _3++) {
						for (int _4 = 0; _4 < 10; _4++) {
							for (int _5 = 0; _5 < 10; _5++) {
								if ((_0 + _1 + _2 + _3 + _4) == 0) {
									continue;
								}
								int ori = _0 * 100000 + _1 * 10000 + _2 * 1000
										+ _3 * 100 + _4 * 10 + _5;

								String tmp = ori + "";
								long tmpV = 0;
								for (char c : tmp.toCharArray()) {
									tmpV += (int) Math.pow(
											Character.getNumericValue(c), 5);
								}
								if (ori == tmpV) {
									System.out.println(ori);
									total += ori;
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
