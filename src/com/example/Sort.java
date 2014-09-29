package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort<T extends Comparable<T>> {

	private T[] a;
	T[] helper;

	public void quickSort(int low, int high) {
		int i = low;
		int j = high;

		T pivot = a[low + (high - low) / 2];

		while (i <= j) {
			while (a[j].compareTo(pivot) <= -1)
				j--;

			while (a[i].compareTo(pivot) >= 1)
				i++;

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(low, j);

		if (i < high)
			quickSort(i, high);
	}

	public void insertionSort() {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			while (j > 0 && a[j].compareTo(a[j - 1]) <= -1) {
				exchange(j, j - 1);
				j--;
			}
		}
	}

	public void selectionSort() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i].compareTo(a[j]) <= -1) {
					exchange(i, j);
				}
			}
		}
	}

	public void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	private void merge(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = a[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (helper[i].compareTo(helper[j]) <= -1) {
				a[k] = helper[i];
				i++;
			} else {
				a[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			a[k] = helper[i];
			k++;
			i++;
		}
	}

	private void exchange(int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public T[] getA() {
		return a;
	}

	public void setA(T[] a) {
		this.a = a;
		this.helper = a.clone();
	}

	public static void main(String[] args) {
		Sort<Integer> s = new Sort<Integer>();
		Integer[] integers = new Integer[10];
		// System.out.println("####### Quick Sort #########");
		// for (int i = 0; i < 10; i++) {
		// integers[i] = (int) (java.lang.Math.random() * 100);
		// }
		// System.out.println(Arrays.toString(integers));
		// s.setA(integers);
		// s.quickSort(0, integers.length - 1);
		//
		// System.out.println(Arrays.toString(integers));
		//
		// System.out.println("####### Insertion Sort #########");
		//
		// for (int i = 0; i < 10; i++) {
		// integers[i] = (int) (java.lang.Math.random() * 100);
		// }
		// System.out.println(Arrays.toString(integers));
		// s.setA(integers);
		// s.insertionSort();
		//
		// System.out.println(Arrays.toString(integers));
		//
		// System.out.println("####### Selection Sort #########");
		//
		// for (int i = 0; i < 10; i++) {
		// integers[i] = (int) (java.lang.Math.random() * 100);
		// }
		// System.out.println(Arrays.toString(integers));
		// s.setA(integers);
		// s.selectionSort();
		//
		// System.out.println(Arrays.toString(integers));
		//
		// System.out.println("####### Merge Sort #########");
		//
		// for (int i = 0; i < 10; i++) {
		// integers[i] = (int) (java.lang.Math.random() * 100);
		// }
		// System.out.println(Arrays.toString(integers));
		// s.setA(integers);
		// s.mergeSort(0, integers.length - 1);
		//
		// System.out.println(Arrays.toString(integers));

		System.out.println("####### Heap Sort #########");

		for (int i = 0; i < 10; i++) {
			integers[i] = (int) (java.lang.Math.random() * 100);
		}
		System.out.println(Arrays.toString(integers));

		Heap<Integer> heap = new Heap<Integer>(Integer.class, integers);
		heap.printHeap();
		// System.out.println(Arrays.toString(integers));
		Integer[] out = new Integer[10];
		for (int i = 0; i < 10; i++)
			out[i] = heap.getMin();

		System.out.println(Arrays.toString(out));

	}

	public static class Heap<T extends Comparable<T>> {

		T[] heapArray;

		T[] array;

		@SuppressWarnings("unchecked")
		public Heap(Class<T> clas, T[] array) {
			this.array = array;
			heapArray = (T[]) Array.newInstance(clas, array.length);
			constructHeap();
		}

		private void constructHeap() {
			for (int i = 0; i < array.length; i++) {
				insertElement(array[i], i);
			}
		}

		private void insertElement(T element, int i) {
			heapArray[i] = element;
			bubbleUp(i);
		}

		private void bubbleUp(int p) {
			if (parent(p) == -1)
				return;
			else if (heapArray[parent(p)].compareTo(heapArray[p]) >= 1) {
				swap(parent(p), p);
				bubbleUp(parent(p));
			}
		}

		private int parent(int p) {
			if (p == 0)
				return -1;

			if (p % 2 == 0)
				return (p - 2) / 2;
			else
				return (p - 1) / 2;

		}

		public void printHeap() {
			System.out.println(Arrays.toString(heapArray));
		}

		public T getMin() {
			if (heapArray == null || heapArray.length == 0)
				return null;

			T min = heapArray[0];
			heapArray[0] = heapArray[heapArray.length - 1];
			heapify(0);
			return min;
		}

		private void heapify(int i) {
			T leftChild = null;
			if (2 * i + 1 < heapArray.length)
				leftChild = heapArray[2 * i + 1];

			T rightChild = null;
			if (2 * i + 2 < heapArray.length)
				rightChild = heapArray[2 * i + 2];

			T parent = heapArray[i];

			if (leftChild == null)
				return;

			if (rightChild == null) {
				if (parent.compareTo(leftChild) >= 1) {
					swap(i, 2 * i + 1);
					return;
				} else {
					return;
				}
			}

			if (parent.compareTo(leftChild) >= 1
					|| parent.compareTo(rightChild) >= 1) {
				if (leftChild.compareTo(rightChild) >= 1) {
					swap(i, 2 * i + 2);
					heapify(2 * i + 2);
				} else {
					swap(i, 2 * i + 1);
					heapify(2 * i + 1);
				}
			}

		}

		private void swap(int i, int j) {
			T temp = heapArray[i];
			heapArray[i] = heapArray[j];
			heapArray[j] = temp;
		}

	}

}
