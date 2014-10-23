package projecteuler_001_025;

public class P1 {

	public static void main(String[] args) {
		int total = 0;
		int range = 1000;
		for (int i = 1; i < range; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				total += i;
			}
		}
		System.out.println(total);
	}
}
