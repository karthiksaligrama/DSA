package com.example;

import java.util.Arrays;

public class SearchOnSortedPivotedArray {

	public static void main(String[] args) {
		Integer[] a = {6,7,8,1,2,3,4,5};
		int firstNumber = a[0];

		int pivot = -1;
		
		Arrays.sort(a);
		pivot = Arrays.binarySearch(a, firstNumber);

		System.out.println("pivot = " + pivot);
		System.out.println("pivot number =" + firstNumber);

		int itemPosition = Arrays.binarySearch(a, 2);

		if (pivot > itemPosition)
			System.out.println(a.length - itemPosition );
		else
			System.out.println(itemPosition - pivot + 1);

	}

}
