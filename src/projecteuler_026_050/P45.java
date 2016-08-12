package projecteuler_026_050;


public class P45 {

	private static long genT(long n) {
		return n * (n + 1) / 2;
	}

	private static long genP(long n) {
		return n * (3 * n - 1) / 2;
	}

	private static long genH(long n) {
		return n * (2 * n - 1);
	}

	public static void main(String[] args) {
		long t = 285;
		long p = 165;
		long h = 143;

		while (true) {
			h++;
			long dest = genH(h);
			while (genP(p) < dest) {
				p++;
			}
			while (genT(t) < dest) {
				t++;
			}
			if (dest == genP(p) && dest == genT(t)) {
				System.out.println(dest);
				break;
			}
		}
	}
}
