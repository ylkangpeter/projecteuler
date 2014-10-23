package projecteuler_001_025;

import java.util.HashMap;
import java.util.Map;

public class P17 {

	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	static {
		map.put(1, 3); // one
		map.put(2, 3); // two
		map.put(3, 5); // three
		map.put(4, 4); // four
		map.put(5, 4); // five
		map.put(6, 3); // six
		map.put(7, 5); // seven
		map.put(8, 5); // eight
		map.put(9, 4); // nine
		map.put(10, 3); // ten
		map.put(11, 6); // eleven
		map.put(12, 6); // twelve
		map.put(13, 8); // thirteen
		map.put(14, 8); // fourteen
		map.put(15, 7); // fifteen
		map.put(16, 7); // sixteen
		map.put(17, 9); // seventeen
		map.put(18, 8); // eighteen
		map.put(19, 8); // nineteen
		map.put(20, 6); // twenty
		map.put(30, 6); // thirty
		map.put(40, 5); // forty
		map.put(50, 5); // fifty
		map.put(60, 5); // sixty
		map.put(70, 7); // seventy
		map.put(80, 6); // eighty
		map.put(90, 6); // ninety
		map.put(100, 7); // hundred
		map.put(1000, 11); // one thousand
	}

	public static void main(String[] args) {
		long total = 0;
		for (int i = 1; i < 1000; i++) {
			total += calc(i);
		}
		System.out.println(total + map.get(1000));
	}

	/**
	 * number is in [1,1000]
	 * 
	 * @param number
	 */
	private static int calc(int number) {
		int result = 0;
		int hundred = number / 100;
		if (hundred > 0) {
			result += map.get(hundred) + map.get(100) + 3;// and
		}
		int mod = number % 100;
		if (mod != 0) {
			if (map.get(mod) != null) {
				result += map.get(mod);
			} else {
				int _10 = mod / 10 * 10;
				int _1 = mod % 10;
				result += map.get(_10);
				result += map.get(_1);
			}
		} else {
			result -= 3;
		}
		System.out.println(number + "\t" + result);
		return result;
	}
}
