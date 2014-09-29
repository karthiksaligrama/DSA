package com.example;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 6, 7, 8, 3 };
		System.out.println(Arrays.toString(a));
		new SelectionSort().selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

	public void selectionSort(int[] a) {
		int min;
		for (int i = 0; i < a.length; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
				swap(i, min, a);
			}
		}
	}

	private void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}