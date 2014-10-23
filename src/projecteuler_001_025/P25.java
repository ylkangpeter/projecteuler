package projecteuler_001_025;

import java.util.ArrayList;
import java.util.List;

public class P25 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Integer> pre = new ArrayList<Integer>();
		List<Integer> cur = new ArrayList<Integer>();
		pre.add(1);
		cur.add(1);

		int pos = 2;
		while (true) {
			if (cur.size() >= 1000) {
				System.out.println(pos);
				break;
			}
			Object[] objs = calc(pre, cur);
			pre = (List<Integer>) objs[0];
			cur = (List<Integer>) objs[1];
			pos++;
		}
		System.out.println(pos);
	}

	private static Object[] calc(List<Integer> pre, List<Integer> cur) {
		pre.add(0);
		pre.add(0);
		cur.add(0);
		cur.add(0);
		for (int i = 0; i < pre.size() - 1; i++) {
			int tmp = cur.get(i) + pre.get(i);
			pre.set(i, tmp % 10);
			pre.set(i + 1, tmp / 10 + pre.get(i + 1));
		}
		if (pre.get(pre.size() - 1) == 0) {
			pre.remove(pre.size() - 1);
			if (pre.get(pre.size() - 1) == 0) {
				pre.remove(pre.size() - 1);
			}
		}
		if (cur.get(cur.size() - 1) == 0) {
			cur.remove(cur.size() - 1);
			if (cur.get(cur.size() - 1) == 0) {
				cur.remove(cur.size() - 1);
			}
		}

		return new Object[] { cur, pre };
	}
}
