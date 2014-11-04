package projecteuler_026_050;

public class P40 {

	// 0.123456789101112131415161718192021...
	public static void main(String[] args) {
		// 1-9 9
		// 10-99 90
		// 100-999 900
		// 1000-9999 9000

		// d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
		int total = 1;
		for (int i = 1; i < 7; i++) {
			int len = (int) Math.pow(10, i);
			int[] result = get(len);
			int group = (int) (result[0] / i);
			int mod = (int) (result[0] % i);
			group += (int) (Math.pow(10, i) * 0.099999999);
			if (mod == 0) {
				total *= Character.getNumericValue(String.valueOf(group)
						.charAt(0));
			} else {
				total *= Character.getNumericValue(String.valueOf((group + 1))
						.charAt(mod - 1));
			}
		}
		System.out.println(total);
	}

	private static int[] get(int len) {
		int group = 0;
		while (true) {
			group++;
			if (len > group * 9 * Math.pow(10, group - 1)) {
				len -= group * 9 * Math.pow(10, group - 1);
				continue;
			}
			break;
		}
		return new int[] { len, group };
	}
}
