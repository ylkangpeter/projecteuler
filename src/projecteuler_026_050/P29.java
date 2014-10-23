package projecteuler_026_050;

public class P29 {

	/**
	 * <pre>
	 * 4 --> 49 
	 * 8 --> 49 
	 * 9 --> 49 
	 * 16 --> 58 
	 * 25 --> 49
	 * 27 --> 49 
	 * 32 --> 48 
	 * 36 --> 49 
	 * 49 --> 49 
	 * 64 --> 62 
	 * 81 --> 58 
	 * 100 --> 49 总共有 618 个重复的。
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int total = 99 * 99;
		for (int i = 2; i <= 10; i++) {
			int j = 2;
			while (Math.pow(i, j) < 101) {
				total = total - 100 / i - 1;
				j++;
			}
			System.out.println(i + " " + j);
		}
		// 4&8&16*64, 9&27*81 should be removed also

		System.out.println(total);
	}
}
