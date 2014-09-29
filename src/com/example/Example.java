package com.example;

public class Example {
	// Given a sorted 2-D array (M x N) containing integers with the following
	// properties:
	//
	// All integers in any row are sorted left to right
	// The first integer in any row is greater than the last integer in the
	// previous row
	//
	//
	// Example
	// 1 3 5 7
	// 10 11 16 20
	// 23 30 34 50
	//
	// Pair {
	// row,
	// column
	// }

	public Pair findTarget(int[][] input, int target) {
		if (input == null)
			return null;

		int m = input.length;// no of rows
		int n = input[0].length;// no columns

		int row = 0;
		for (int i = 0; i < m; i++) {
			if (target >= input[i][0] && target <= input[i][n - 1]) {
				row = i;
				break;
			}
		}
		// O(M)
		// O(logN)
		int indexOfColumn = binarySearch(input[row], 0, n, target);
		// O(M+logN)

		return new Pair(row, indexOfColumn);
	}

	private int binarySearch(int[] array, int low, int high, int target) {
		if (low > high)
			return -1;

		if (low == high)
			return low;

		int mid = low + (low + high) / 2;

		if (array[mid] == target)
			return mid;

		if (array[mid] > target) {
			return binarySearch(array, low, mid - 1, target);
		} else if (array[mid] < target) {
			return binarySearch(array, mid + 1, high, target);
		}

		return -1;
	}

	/**
	 * Returns a^b, as the standard mathematical exponentiation function
	 */
	public double pow(double a, int b) {

		if (a == 0)
			return 0;
		if (b == 0)
			return 1;
		if (b == 1)
			return a;

		boolean isNeg = (b > 0) ? false : true;// tell whether the exponet is
												// negtetive

		if (isNeg) {
			b *= -1;
		}

		double retVal = 0;
		if (b % 2 == 0) {
			retVal = pow(a * a, b / 2);
		} else {
			retVal = a * pow(a * a, (b - 1) / 2);
		}

		if (isNeg)
			return 1 / retVal;

		return retVal;
		// implementation here
	}

	// test cases:
	// a=0.0 b=1 return =0
	// a=2.0 b=1 return = 2.0
	// a=2.0 b=3 return = 8.0
	// a=2.0 b=-3 return = 0.125

	private static class Pair {
		int row;
		int column;

		public Pair(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
}
