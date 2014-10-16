package projecteuler;

public class P12 {

	public static void main(String[] args) {
		int totalDiv = 500;
		long tNumber = 0;
		for (int i = 1;; i++) {
			tNumber += i;
			int counter = 0;
			for (long j = 1; j < tNumber / 2 + 1; j++) {
				if (tNumber % j == 0) {
					counter++;
				}
			}
			System.out.println(i + " " + counter + " " + tNumber);
			if (counter >= totalDiv) {
				System.out.println(tNumber);
				break;
			}
		}

	}

}
