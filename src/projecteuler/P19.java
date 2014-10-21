package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class P19 {

	// sunday 0 , monday 1 etc

	private static int dayOfWeek_for_start = (365 + 1) % 7; // 19010101

	public static void main(String[] args) {

		int total = 0;
		for (int i = 0; i < 99; i++) {
			total += calc(i % 3 == 0);
		}
		total += calc(true);
		System.out.println(total);
		// for (int i = 0; i < 100; i++) {
		// boolean isLeap = false;
		// if (i % 4 == 3) {
		// isLeap = true;
		// }
		// if (dayOfWeek_for_yearStart == 0) {
		// total += 5;
		// } else {
		// int nextSunday = 7 - dayOfWeek_for_yearStart + 1;
		// total++;
		// total += (31 - nextSunday) / 7;
		// if ((31 - nextSunday) % 7 == 0) {
		// total--;
		// }
		// }
		// if (isLeap) {
		// dayOfWeek_for_yearStart = (dayOfWeek_for_yearStart + 366) % 7;
		// } else {
		// dayOfWeek_for_yearStart = (dayOfWeek_for_yearStart + 365) % 7;
		// }
		// System.out.println(total);
		// }
	}

	private static int calc(boolean isLeap) {
		int total = 0;
		for (int i = 1; i < 13; i++) {
			if (dayOfWeek_for_start == 0) {
				total++;
			}
			dayOfWeek_for_start = getNext(i, isLeap);
		}
		return total;
	}

	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	static {
		map.put(1, 31);
		map.put(3, 31);
		map.put(4, 30);
		map.put(5, 31);
		map.put(6, 30);
		map.put(7, 31);
		map.put(8, 31);
		map.put(9, 30);
		map.put(10, 31);
		map.put(11, 30);
		map.put(12, 31);

	}

	private static int getNext(int monthNumber, boolean isLeap) {
		if (monthNumber == 2)
			if (isLeap) {
				return (dayOfWeek_for_start + 29) % 7;
			} else {
				return (dayOfWeek_for_start + 28) % 7;
			}
		return (map.get(monthNumber) + dayOfWeek_for_start) % 7;
	}
}
