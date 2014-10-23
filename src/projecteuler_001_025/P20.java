package projecteuler_001_025;

public class P20 {

	private static int[] value = new int[200];

	public static void main(String[] args) {
		value[0] = 1;

		for (int i = 2; i <= 100; i++) {
			calc(value, i);
		}
		long total = 0;
		for (int i = 0; i < value.length; i++) {
			total += value[i];
		}
		System.out.println(total);
	}

	private static void calc(int[] arr, int val) {
		int left = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = left % 10;
				left = left / 10;
				continue;
			}
			int re = arr[i] * val + left;
			// addup(re, arr, i);
			arr[i] = re % 10;
			left = re / 10;
			len = i;
		}
		int tmp = arr[len + 1] + left;
		arr[len + 1] = tmp % 10;
		left = tmp / 10;
		tmp = arr[len + 2] + left;
		arr[len + 2] = tmp % 10;
		left = tmp / 10;
		tmp = arr[len + 3] + left;
		arr[len + 3] += tmp % 10;
		left = tmp / 10;
		if (left != 0) {
			tmp = arr[len + 4] + left;
			arr[len + 4] += tmp % 10;
		}
	}
}
