package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class P16 {

	public static void main(String[] args) {
		List<Integer> value = new ArrayList<Integer>();
		value.add(1);
		int pow = 1000;

		for (int i = 1; i <= pow; i++) {
			calc(value, 2);
		}
		int re = 0;
		for (Integer integer : value) {
			re += integer;
		}
		System.out.println(re);
	}

	private static void calc(List<Integer> value, int factor) {
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
}
