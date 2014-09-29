package com.example;

import java.lang.Math;
import java.util.Arrays;

public class QuickSort {

	public int[] a;

	public QuickSort() {
		a = new int[10];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			j= (int) (Math.random() * 100);
			if(j == 0){
				i--;
				continue;
			}
			a[i]=j;
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
		
		System.out.println(Arrays.toString(a));
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

	private void printA(){
		System.out.println("#####printing######");
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String args[]) {
		QuickSort qs = new QuickSort();
		qs.sort(0, qs.a.length - 1);
		qs.printA();
	}

}
