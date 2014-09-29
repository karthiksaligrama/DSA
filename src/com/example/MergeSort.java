package com.example;

public class MergeSort {
	public static void main(String[] args) {

	}

	public void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid, high);
			merge(low, mid, high);
		}
	}

	private void merge(int low, int middle, int high) {
		
		for(int i=low;i<high;i++){
			
		}
	}
}
