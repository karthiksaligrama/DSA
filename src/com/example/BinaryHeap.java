package com.example;

import java.util.Arrays;

public class BinaryHeap {

	private int[] heap = { 11, 17, 12, 18, 21, 13, 17, 43, 23, 26, 29, 31, 19 };

	public static void main(String[] args) {
		BinaryHeap h = new BinaryHeap();
//		h.insert(32);
		h.deleteMin();
	}

	public void insert(int a) {
		System.out.println(Arrays.toString(heap));
		incrementSize();
		heap[heap.length - 1] = a;

		for (int i = (heap.length - 1) / 2; i >= 0; i--) {
			heapify(i);
		}
		System.out.println(Arrays.toString(heap));
		
		
	}

	public void deleteMin() {
		System.out.println(Arrays.toString(heap));
		heap[0] = heap[heap.length - 1];// replace the last element with the top
		// element;
		int[] tmp = heap.clone();
		heap = new int[heap.length-1];
		for(int i=0;i<heap.length;i++){
			heap[i] = tmp[i];
		}
		System.out.println(Arrays.toString(heap));
		
		for (int i = (heap.length - 1) / 2; i >= 0; i--) {
			heapify(i);
		}
		
	}

	public void heapify(int i) {
		System.out.println(Arrays.toString(heap));
		int l, r, min;

		l = 2 * i + 1;
		r = 2 * i + 2;

		if (l < heap.length && heap[l] <= heap[i])
			min = l;
		else
			min = i;

		if (r < heap.length && heap[r] <= heap[min])
			min = r;

		if (min != i) {
			swap(i, min, heap);
			heapify(min);
		}
	}

	private void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void incrementSize() {
		int[] temp = heap.clone();
		heap = new int[temp.length + 1];
		for (int i = 0; i < temp.length; i++) {
			heap[i] = temp[i];
		}
	}

}
