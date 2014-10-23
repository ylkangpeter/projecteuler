package projecteuler_026_050;


public class P28 {

	public static void main(String[] args) {
		long total = 1;
		for (int i = 2; i < 502; i++) {
			int val = (2 * i - 1) * (2 * i - 1);
			System.out.print(val + " ");
			System.out.print(val - 2 * i + 2 + " ");
			System.out.print(val - 2 * (2 * i - 2) + " ");
			System.out.println(val - 3 * (2 * i - 2) + " ");
			total = total + 4 * val - 12 * i + 12;
		}
		System.out.println(total);
	}
}
