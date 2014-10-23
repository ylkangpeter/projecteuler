package projecteuler_001_025;

/**
 * 
 * 01432
 * 
 * <pre>
 * 1. find 1st increasing pair: 14
 * 2. mark 1, find smallest number after 1: 432 -> 2
 * 3. swap 1,2 -> 02431
 * 4. reverse 431 -> 02134
 * </pre>
 * 
 * @author ylkang Oct 22, 2014
 */

public class P24_permutation {

	public static void main(String[] args) throws Exception {
		int upperBorder = 1000000;
		int noForEachCap = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
		int finalCap = 0;
		int total = 0;
		for (finalCap = 0; finalCap < 10; finalCap++) {
			total += noForEachCap;
			if (total > upperBorder) {
				break;
			}
		}
		total -= noForEachCap;
		System.out.println(finalCap);

		int[] init = { 2, 0, 1, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = total + 1; i < 1000000; i++) {
			genNext(init);
		}
		for (int i = 0; i < init.length; i++) {
			System.out.print(init[i]);
		}

	}

	public static void genNext(int[] arr) throws Exception {
		int marker = arr.length - 1;
		boolean isChange = false;
		for (; marker > 0; marker--) {
			if (arr[marker] > arr[marker - 1]) {
				isChange = true;
				break;
			}
		}
		if (!isChange) {
			throw new Exception("no more");
		}
		marker--;
		int minInx = marker + 1;
		for (int i = marker + 1; i < arr.length; i++) {
			if (arr[i] > arr[marker]) {
				minInx = (arr[minInx] > arr[i] ? i : minInx);
			}
		}
		int tmp = arr[marker];
		arr[marker] = arr[minInx];
		arr[minInx] = tmp;
		swap(arr, marker + 1, arr.length - 1);
	}

	private static void swap(int[] arr, int start, int end) {
		if (start == end)
			return;
		for (int i = 0; i <= (end - start + 1) / 2 && start + i < end - i; i++) {
			int tmp = arr[start + i];
			arr[start + i] = arr[end - i];
			arr[end - i] = tmp;
		}

	}
}
