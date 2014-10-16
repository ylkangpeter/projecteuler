package projecteuler;

public class P2 {

	public static void main(String[] args) {
		fibonacci(2, 1);
		System.out.println(total);
	}

	private static long total = 0;

	private static void fibonacci(int current, int pre) {
		System.out.println(pre + "\t" + current);
		if (current % 2 == 0) {
			total += current;
		}
		if (current + pre <= 4000000) {
			fibonacci(current + pre, current);
		}
	}
}
