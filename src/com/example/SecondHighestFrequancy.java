package com.example;

import java.util.HashMap;

public class SecondHighestFrequancy {

	public static void main(String[] args) {
		String s = "aaabbcccc";

		char[] a = s.toCharArray();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				Integer j = ((Integer) map.get(a[i])) + 1;
				map.put(a[i] + "", j);
			} else {
				map.put(a[i] + "", 1);
			}
		}

		// after this we can just get the values and find out which char has the
		// second highest freq.
	}

}
