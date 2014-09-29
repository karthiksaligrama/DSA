package com.example;

public class SumOfNNumbers {

	public Double recursiveSum(Integer maxNumber) {
		if (maxNumber > 0)
			return (double) maxNumber + recursiveSum(maxNumber - 1);
		else
			return (double) 0;
	}

	public static void main(String[] args) {
		SumOfNNumbers s = new SumOfNNumbers();
		System.out.println(s.recursiveSum(10));
		System.out.println(s.arthimeticSolution(Integer.MAX_VALUE));
		System.out.println(s.iterativeSum(Integer.MAX_VALUE));
	}

	public Double iterativeSum(double maxNumber) {
		Double sum = (double) 0;
		for (int i = 1; i <= maxNumber; i++) {
			sum += i;
		}
		return sum;
	}

	public Double arthimeticSolution(double maxNumber) {
		return (maxNumber * (maxNumber)) / 2;
	}

}
