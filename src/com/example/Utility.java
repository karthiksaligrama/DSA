package com.example;

import java.lang.Math;
import java.util.Arrays;

public class Utility {

	int[] a;

	public Utility() {
		a = new int[10];
	}

	private void initializeList() {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}

		System.out.println(Arrays.toString(a));
	}

	public void sort(int low, int high) {

		int pivot = a[low + (high - low) / 2];
		int i = low;
		int j = high;

		while (i <= j) {
			while (a[j] < pivot)
				j--;

			while (a[i] > pivot)
				i++;

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			sort(low, j);

		if (i < high)
			sort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String args[]) {
		Utility u = new Utility();
		// u.initializeList();
		//
		// u.sort(0, u.a.length - 1);
		// System.out.println("#####printing######");
		// System.out.println(Arrays.toString(u.a));

		System.out.println(parseInt("-12323"));
	}

	public static Integer parseInt(String s) {
		Integer returnInt = new Integer(0);
		if (s == null)
			throw new IllegalArgumentException("Input is null");

		char[] c = s.toCharArray();
		boolean isNeg = false;

		if (c[0] == '-')
			isNeg = true;

		for (int i = 0; i < c.length; i++) {
			if (i == 0 && isNeg)
				continue;
			returnInt *= 10;
			int ascii = c[i] - 48;

			if (!(ascii >= 0 && ascii < 10))
				throw new IllegalArgumentException("Not a valid integer");

			returnInt += ascii;
		}
		return returnInt;
	}

	public static int ipow(int base, int exp) {
		int result = 1;
		while (exp != 0) {
			if ((exp & 1) != 0)
				result *= base;
			exp >>= 1;
			base *= base;
		}

		return result;
	}

}