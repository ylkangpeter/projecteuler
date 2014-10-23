package projecteuler_026_050;


public class P34 {

	private static int[] val = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

	public static void main(String[] args) {
		// 9999999 -> 9!*7 ->7 figure, can't be larger anymore

		// FIXME just use for(i in 1...9999999)
		long total = 0;
		for (int i = 3; i < 9999999; i++) {
			if (i == get(i)) {
				total += i;
			}
		}
		System.out.println(total);
	}

	private static int get(int num) {
		int total = 0;
		for (char c : (num + "").toCharArray()) {
			total += val[Character.getNumericValue(c)];
		}
		return total;
	}
}
