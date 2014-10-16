package projecteuler;

public class P4 {

	public static void main(String[] args) {
		int answer = 0;
		int a = 0;
		int b = 0;

		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				String val = "" + j * i;
				boolean isOk = true;

				for (int k = 0; k < val.length() / 2; k++) {
					if (val.charAt(k) != val.charAt(val.length() - k - 1)) {
						isOk = false;
						break;
					}
				}

				if (isOk && answer < j * i) {
					a = i;
					b = j;
					answer = j * i;
				}
			}
		}
		System.out.println(answer);
		System.out.println(a + "\t" + b);

	}
}
