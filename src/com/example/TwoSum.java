package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

	private List<Integer> list;

	private Set<Integer> setOfSums;

	public TwoSum() {
		list = new ArrayList<Integer>();
		setOfSums = new HashSet<Integer>();
	}

	/**
	 * Stores @param input in an internal data structure.
	 */
	public void store(int input) {
		list.add(input);

		populateHashset();
	}

	private void populateHashset() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;

				setOfSums.add(list.get(i) + list.get(j));
			}
		}
	}

	/**
	 * Returns true if there is any pair of numbers in the internal data
	 * structure which have sum @param test, and false otherwise. For example,
	 * if the numbers 1, -2, 3, and 6 had been stored, the method should return
	 * true for 4, -1, and 9, but false for 10, 5, and 0
	 */
	public boolean test(int test) {
		return setOfSums.contains(test);
	}

	public static void main(String args[]) {
		TwoSum ts = new TwoSum();

		ts.store(1);
		ts.store(-2);
		ts.store(3);
		ts.store(6);

		System.out.println(ts.test(4));
		System.out.println(ts.test(-1));
		System.out.println(ts.test(9));
		System.out.println(ts.test(10));
		System.out.println(ts.test(5));
		System.out.println(ts.test(0));
	}
}
