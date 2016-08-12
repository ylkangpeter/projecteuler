package projecteuler_051_100;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class P54 {

	public static void main(String[] args) {
		BufferedReader br = null;
		int total = 0;
		try {
			br = new BufferedReader(new FileReader(new File(P54.class
					.getResource("p054_poker.txt").getPath())));
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.replaceAll("J", "b").replaceAll("Q", "c")
						.replaceAll("K", "d").replaceAll("T", "a")
						.replaceAll("A", "e");
				String[] tmps = line.split(" ");
				List<String> p1 = new ArrayList<String>();
				for (int i = 0; i < 5; i++) {
					p1.add(tmps[i]);
				}
				List<String> p2 = new ArrayList<String>();
				for (int i = 5; i < 10; i++) {
					p2.add(tmps[i]);
				}
				long rank1 = calcRank(p1);
				long rank2 = calcRank(p2);
				if (rank1 > rank2) {
					System.out.println(p1.toString() + p2.toString() + " "
							+ rank1 + " " + rank2);
					total++;
				}
				if (rank1 == rank2) {
					Collections.sort(p1);
					Collections.sort(p2);
					for (int i = 0; i < p1.size(); i++) {
						if (p1.get(i).compareTo(p2.get(i)) > 0) {
							total++;
							break;
						}
					}
				}
			}
			System.out.println(total);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * <pre>
	 * rank len: 10
	 * 1-8: special
	 * 9-10: value
	 * </pre>
	 * 
	 * /**
	 * 
	 * <pre>
	 * 1.num+color
	 * 2.consecutive + color
	 * 3.3 same color + pair
	 * 4.5 same color
	 * 5.consecutive
	 * 6.3 same value
	 * 7.two pair
	 * 8.one pair
	 * 9.ace
	 * 10.king
	 * 11. queen
	 * 12. jason
	 * 13. 10
	 * etc
	 * 
	 * </pre>
	 * 
	 * @return
	 */
	private static long calcRank(List<String> p1) {
		long rank = 0;
		// 1
		// same color
		int sameColor = 0;
		Map<Character, Integer> colorMap = new HashMap<Character, Integer>();
		for (String str : p1) {
			char cc = str.charAt(1);
			Integer counter = colorMap.get(cc);
			if (counter == null) {
				counter = 0;
			}
			counter++;
			colorMap.put(cc, counter);
			if (counter > sameColor)
				sameColor = counter;
		}

		int biggestApperance = 0;
		int biggestCard = 0;
		int num = 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		TreeSet<Integer> numSet = new TreeSet<Integer>();
		for (String str : p1) {
			char cc = str.charAt(0);
			int val = Integer.parseInt(cc + "", 16);
			numSet.add(val);
			Integer counter = m.get(val);
			if (counter == null) {
				counter = 0;
			}
			counter++;
			m.put(val, counter);
			if (counter > biggestApperance) {
				biggestApperance = counter;
				num = val;
			}
			if (val > biggestCard) {
				biggestCard = val;
			}
		}

		if (numSet.size() == 4) {
			rank += (num * Math.pow(16, 1));
		}
		if (numSet.size() == 3) {
			if (biggestApperance == 2)
				rank += (num * Math.pow(16, 2));
			else
				rank += (num * Math.pow(16, 3));
		}
		if (numSet.size() == 2) {
			if (biggestApperance == 4)
				rank += (num * Math.pow(16, 7));
			else {
				rank += (num * Math.pow(16, 6));
			}
		}
		rank += Integer.parseInt(numSet.last() + "");

		boolean isConsecutive = true;
		for (int i = numSet.first(); i < numSet.first() + 5; i++) {
			if (!numSet.contains(i)) {
				isConsecutive = false;
				break;
			}
		}
		if (sameColor == 5) {
			rank += 0x100000;
			// royal or normal
			if (isConsecutive && numSet.first() == 10) {
				rank += 0x1000000000L;
			} else if (isConsecutive) {
				rank += 0x100000000L;
			}
		} else {
			if (isConsecutive) {
				rank += 0x10000;
			}
		}
		return rank;
	}
}
