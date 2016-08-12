package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 136 {

	public static Map<Integer, Integer> getPrimeFactors(long num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		long rest = num;
		while (rest != 1) {
			for (int i = 2; i <= rest; i++) {
				if (rest % i == 0) {
					Integer count = map.get(i);
					if (count == null) {
						count = 0;
					}
					count++;
					map.put(i, count);
					rest /= i;
					break;
				}
			}
		}
		return map;
	}

	public static List<Integer> add(List<Integer> value, List<Integer> addUp) {

		value.add(0);
		addUp.add(0);
		List<Integer> tmpList = value;
		if (value.size() > addUp.size()) {
			tmpList = addUp;
		} else {
			value = addUp;
		}

		int promotion = 0;
		for (int i = 0; i < tmpList.size(); i++) {
			int tmp = value.get(i) + tmpList.get(i) + promotion;
			promotion = tmp / 10;
			tmp = tmp % 10;
			value.set(i, tmp);
		}
		int inx = tmpList.size();
		while (promotion != 0) {
			int tmp = promotion + value.get(inx);
			promotion = tmp / 10;
			tmp = tmp % 10;
			value.set(inx, tmp);
			inx++;
		}
		for (int i = value.size() - 1; i >= 0; i--) {
			if (value.get(i) == 0) {
				value.remove(i);
				continue;
			}
			break;
		}
		return value;
	}

	public static void main(String[] args) {
		getPrimeFactors(644);
		System.out.println();
	}

	public static List<Integer> multi(List<Integer> val1, List<Integer> val2) {

		List<Integer> result = new ArrayList<Integer>();
		int size = val1.size() + val2.size();
		for (int i = 0; i < size; i++) {
			result.add(0);
		}

		for (int i = 0; i < val1.size(); i++) {
			LinkedList<Integer> tmpResult = new LinkedList<Integer>();
			int factor = val1.get(i);
			int promotion = 0;
			for (int j = 0; j < val2.size(); j++) {
				int tmp = val2.get(j) * factor + promotion;
				promotion = tmp / 10;
				tmp = tmp % 10;
				tmpResult.add(tmp);
			}
			if (promotion != 0) {
				char[] tmp = (promotion + "").toCharArray();
				for (int m = tmp.length - 1; m >= 0; m--) {
					tmpResult.add(Character.getNumericValue(tmp[m]));
				}
			}
			for (int k = 0; k < i; k++) {
				tmpResult.add(0, 0);
			}
			result = add(result, tmpResult);
		}
		return result;
	}

	public static void pow(List<Integer> value, int factor) {
		int promotion = 0;
		value.add(0);
		for (int i = 0; i < value.size(); i++) {
			int tmp = value.get(i) * factor + promotion;
			promotion = tmp / 10;
			tmp = tmp % 10;
			value.set(i, tmp);
		}
		if (value.get(value.size() - 1) == 0) {
			value.remove(value.size() - 1);
		}
	}

	public static boolean isPrime(long num) {
		if (num == 1)
			return false;
		for (int j = 2; j < (long) Math.sqrt(num) + 1; j++) {
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}

	public static void genNextPerm(int[] arr) throws Exception {
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

	public static int[] genPrimeNumber(int len) {
		int[] result = new int[len];
		int counter = 0;
		int number = 2;
		while (counter < len) {
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(number) + 1; j++) {
				if (number % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				result[counter] = number;
				counter++;
				number++;
			}
		}
		return result;
	}

	public static Set<Long> genPrimeNumberBelow(long max) {
		Set<Long> set = new HashSet<Long>();
		long number = 2;
		while (number < max) {
			boolean isPrime = true;
			for (long j = 2; j < (long) Math.sqrt(number) + 1; j++) {
				if (number % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				set.add(number);
			}
			number++;
			// if (number % 1000 == 0)
			// System.out.println(number);
		}
		return set;
	}

	public static long genNextPrimeNumber(long start, String exceptChar) {
		while (true) {
			start++;
			String tmp = start + "";
			boolean isOk = true;
			for (char c : exceptChar.toCharArray()) {
				if (tmp.indexOf(c) >= 0) {
					isOk = false;
					break;
				}
			}
			if (!isOk) {
				continue;
			}
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(start) + 1; j++) {
				if (start % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				return start;
			}
		}
	}

	public static long genNextDescPrimeNumber(long start, String exceptChar) {
		while (true) {
			start--;
			String tmp = start + "";
			boolean isOk = true;
			for (char c : exceptChar.toCharArray()) {
				if (tmp.indexOf(c) >= 0) {
					isOk = false;
					break;
				}
			}
			if (!isOk) {
				continue;
			}
			boolean isPrime = true;
			for (int j = 2; j < (long) Math.sqrt(start) + 1; j++) {
				if (start % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				return start;
			}
		}
	}

	// public static int[] fibonacci(int len) {
	// int[]
	// }

	public static int fibonacci(int position) {
		if (position == 2) {
			return 1;
		} else if (position == 1) {
			return 1;
		} else {
			return fibonacci(position - 1) + fibonacci(position - 2);
		}
	}

	public static List<Integer> getDivider(int num, boolean includeSelf) {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i < num / 2 + 1; i++) {
			if (num % i == 0) {
				l.add(i);
			}
		}
		if (includeSelf) {
			l.add(num);
		}
		return l;
	}

	public static Set<List<Integer>> genPermutation(List<Integer> raw) {
		Set<List<Integer>> tmp = new HashSet<List<Integer>>();
		perm(0, raw.size() - 1, raw, tmp);
		return tmp;

	}

	public static long getNormalFormInt(int[] arr) {
		long val = 0;
		for (int i = 0; i < arr.length; i++) {
			val += Math.pow(10, arr.length - 1 - i) * arr[i];
		}
		return val;
	}

	public static int getNormalFormInt(List<Integer> list) {
		int val = 0;
		for (int i = 0; i < list.size(); i++) {
			val += Math.pow(10, i) * list.get(i);
		}
		return val;
	}

	public static List<Integer> getListFormInt(String val) {
		List<Integer> ll = new ArrayList<Integer>();
		char[] chars = val.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			ll.add(Character.getNumericValue(chars[i]));
		}
		return ll;
	}

	private static void perm(int start, int end, List<Integer> raw,
			Set<List<Integer>> result) {
		if (start == end) {
			List<Integer> tmpList = new ArrayList<Integer>();
			tmpList.addAll(raw);
			result.add(tmpList);
			// for (Integer integer : raw) {
			// System.out.print(integer);
			// }
			// System.out.println();

		} else {
			for (int i = start; i <= end; i++) {
				int tmp = raw.get(start);
				raw.set(start, raw.get(i));
				raw.set(i, tmp);
				perm(start + 1, end, raw, result);
				raw.set(i, raw.get(start));
				raw.set(start, tmp);
			}
		}
	}
}
