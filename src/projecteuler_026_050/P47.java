package projecteuler_026_050;

import java.util.Map;

import util.Util;

public class P47 {

	public static void main(String[] args) {
		int i = 100;
		while (true) {
			Map<Integer, Integer> m = Util.getPrimeFactors(i);
			if (m.size() == 4) {
				m = Util.getPrimeFactors(i + 1);
				if (m.size() == 4) {
					m = Util.getPrimeFactors(i + 2);
					if (m.size() == 4) {
						m = Util.getPrimeFactors(i + 3);
						if (m.size() == 4) {
							System.out.println(i);
							break;
						} else {
							i += 4;
						}
					} else {
						i += 3;
					}
				} else {
					i += 2;
				}
			} else {
				i++;
			}
		}

	}
}
