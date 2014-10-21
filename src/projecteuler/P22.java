package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class P22 {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(new File(P22.class
					.getResource("p22.txt").getPath())));
			String line = br.readLine();
			String[] names = line.split(",");
			Arrays.sort(names, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});

			long value = 0;
			for (int i = 1; i < names.length + 1; i++) {
				value += calc(names[i - 1]) * i;
			}
			System.out.println(value);
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

	private static int calc(String string) {
		int val = 0;
		for (char c : string.toCharArray()) {
			val += c - 64;
		}
		return val;
	}
}
