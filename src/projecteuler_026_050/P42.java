package projecteuler_026_050;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import projecteuler_001_025.P22;

public class P42 {
	private static final Set<Integer> triangleNumSet = new HashSet<Integer>();

	static {
		for (int i = 1; i < 1000; i++) {
			triangleNumSet.add(i * (i + 1) / 2);
		}
	}

	public static void main(String[] args) {
		BufferedReader br = null;
		int total = 0;
		try {
			br = new BufferedReader(new FileReader(new File(P42.class
					.getResource("p042_words.txt").getPath())));
			String line = br.readLine();
			for (String str : line.split(",")) {
				int val = calc(str);
				if (triangleNumSet.contains(val)) {
					total++;
				}
			}
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
		System.out.println(total);
	}

	private static int calc(String string) {
		int val = 0;
		for (int i = 1; i < string.length() - 1; i++) {
			val += string.charAt(i) - 64;
		}
		return val;
	}
}
