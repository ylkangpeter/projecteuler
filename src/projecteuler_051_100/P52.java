package projecteuler_051_100;

import java.util.List;

import util.Util;

public class P52 {

	public static void main(String[] args) {
		long num = 120123;
		int size = 6;
		while (true) {
			num++;
			List<Integer> l = Util.getListFormInt(String.valueOf(num));
			if (l.size() > size) {
				num = 12 * (long) Math.pow(10, size);
				size++;
				continue;
			}
			List<Integer> ll = Util.getListFormInt(String.valueOf(num * 2));
			if (ll.retainAll(l)) {
				continue;
			}
			ll = Util.getListFormInt(String.valueOf(num * 3));
			if (ll.retainAll(l)) {
				continue;
			}
			ll = Util.getListFormInt(String.valueOf(num * 4));
			if (ll.retainAll(l)) {
				continue;
			}
			ll = Util.getListFormInt(String.valueOf(num * 5));
			if (ll.retainAll(l)) {
				continue;
			}
			ll = Util.getListFormInt(String.valueOf(num * 6));
			if (ll.retainAll(l)) {
				continue;
			}
			System.out.println(num);
			break;
		}
	}
}
