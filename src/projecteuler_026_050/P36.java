package projecteuler_026_050;

public class P36 {

	public static void main(String[] args) {
		long total = 0;
		for (int i = 1; i <= 1000000; i++) {
			StringBuilder sb = new StringBuilder(i + "");
			int start = 0, end = sb.length() - 1;
			boolean isOk = true;
			while (start < end) {
				if (sb.charAt(start) != sb.charAt(end)) {
					isOk = false;
					break;
				}
				start++;
				end--;
			}
			if (isOk) {
				sb = new StringBuilder(Integer.toBinaryString(i));
				start = 0;
				end = sb.length() - 1;
				while (start < end) {
					if (sb.charAt(start) != sb.charAt(end)) {
						isOk = false;
						break;
					}
					start++;
					end--;
				}
				if (isOk) {
					total += i;
					System.out.println(i + " " + Integer.toBinaryString(i));
				}
			}
		}
		System.out.println(total);
	}
}
