package projecteuler;

public class P6 {

	public static void main(String[] args) {
		long val = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = i + 1; j <= 100; j++) {
				val += 2 * i * j;
			}
		}
		System.out.println(val);
	}

}
