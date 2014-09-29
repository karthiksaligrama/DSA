package com.example;

import java.util.Arrays;

public class BubbleSort {

	int[] a = { 34, 45, 6, 3, 45, 78, 56, 72, 2 };

	public static void main(String[] args) {

		new BubbleSort().bubbleSort();
	}

	public void bubbleSort() {
		System.out.println(Arrays.toString(a));
		int j;
		boolean flag;
		int temp;

		System.out.println(Arrays.toString(a));
	}

	private void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
