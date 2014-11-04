package projecteuler_051_100;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class P97 {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		for (int i = 1; i <= 7830457; i++) {
			if (i % 1000 == 0)
				System.out.println(i);
			List<Integer> ll = new ArrayList<Integer>();
			ll.add(2);
			l = Util.multi(l, ll);
			if (l.size() > 10) {
				l = l.subList(0, 10);
			}
		}
		List<Integer> ll = new ArrayList<Integer>();
		ll.add(3);
		ll.add(3);
		ll.add(4);
		ll.add(8);
		ll.add(2);
		l = Util.multi(l, ll);
		for (int i = 9; i >= 0; i--) {
			System.out.print(l.get(i));
		}
		// add 1 at last!!!
	}
}
