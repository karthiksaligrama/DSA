package com.example;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args){
		int[] a = {1,5,2,6,7,8,3};
		System.out.println(Arrays.toString(a));
		new InsertionSort().insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	
	public void insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int j=i;
			while(j>0 && a[j]<a[j-1]){
				swap(j,a);
				j--;
			}
		}
	}
	
	private void swap(int j,int[] a){
		int temp=a[j];
		a[j] = a[j-1];
		a[j-1] = temp;
	}
	
}
