package com.example;

import java.util.Arrays;
import java.util.HashSet;

public class CombinationOf3Numbers {

	public static void main(String[] args) {
		Integer[] inputList = { 2, 3, 1, -2, -1, 0, 2, -3, 0 };
		new CombinationOf3Numbers().findTheNumbers(inputList);
	}

	public void findTheNumbers(Integer[] inputList) {
		Arrays.sort(inputList);

		HashSet<Integer> m = new HashSet<Integer>();
		//O(n)
		for (int i = 0; i < inputList.length; i++) {
			m.add(inputList[i]);
		}

		HashSet<DS> map = new HashSet<DS>();

		for (int i = 0; i < inputList.length; i++) {
			for (int j = i; j < inputList.length; j++) {
				if (m.contains(-1 * (inputList[i] + inputList[j]))) {
					DS a = new DS();
					a.a[0] = inputList[i];
					a.a[1] = inputList[j];
					a.a[2] = -1 * (inputList[i] + inputList[j]);
					map.add(a);
				}
			}
		}

		for (DS ds : map) {
			System.out.println(ds);
		}

	}

	class DS {
		int[] a;

		public DS() {
			a = new int[3];
		}
		
		@Override
		public int hashCode() {
			return a[0]*1 + a[1]*1 + a[2]*2;
		}
		
		@Override
		public boolean equals(Object obj) {
			DS newInstance = (DS) obj;
			return this.a[0] == newInstance.a[0]
					&& this.a[1] == newInstance.a[1]
					&& this.a[2] == newInstance.a[2];
		}

		public String toString() {
			return a[0] + " , " + a[1] + ", " + a[2];
		}
	}

}
