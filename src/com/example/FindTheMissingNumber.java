package com.example;

import java.util.Arrays;

public class FindTheMissingNumber {

	public static void main(String[] args) {
		int[] a = { 4, 2, 5, 1 };
		System.out.print(new FindTheMissingNumber().find(a, 5));
		System.out.print(new FindTheMissingNumber().find(5, a));
	}

	// O(nlogn)
	public int find(int[] numbers, int size) {

		Arrays.sort(numbers);

		for (int i = 0; i < size - 1; i++) {
			if (numbers[i + 1] != numbers[i] + 1) {
				return numbers[i] + 1;
			}
		}

		return 0;
	}
	
	// O(n)
	public int find(int size, int[] numbers) {
		int number = (size + 1) * size / 2;
		for (int i = 0; i < size - 1; i++) {
			number -= numbers[i];
		}

		return number;
	}

}
