package com.example;

import java.util.Date;

//a^b = (a^b/2)^2

public class Math {

	public static double pow(double a, double b) {
		if (a == 0)
			return 0;

		if (b == 0)
			return 1;

		if (b < 0) {
			return 1 / a * pow(a, b + 1);
		} else {
			return a * pow(a, b - 1);
		}
	}

	public static double iPow(double a, double b) {
		if (a == 0)
			return 0;

		if (b == 0)
			return 1;

		if (b < 0)
			return 1 / a * iPow(a, b + 1);
		else {
			if (b == 1)
				return a;
			else if (b % 2 == 0) {
				return iPow(a * a, b / 2);
			} else {
				return a * iPow(a * a, (b - 1) / 2);
			}
		}
	}

	static float sqrt(float n) {
		float low = 0, high = n;
		float mid = (low + high) / 2;
		while (java.lang.Math.abs(mid * mid - n) > 0.00001) {
			if (mid * mid < n)
				low = mid;
			else if (mid * mid > n)
				high = mid;
			mid = (low + high) / 2;
		}
		return mid;
	}

	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		System.out.println(iPow(2, 30));
		System.out.println(new Date().getTime());

		System.out.println(new Date().getTime());
		System.out.println(pow(2, 30));
		System.out.println(new Date().getTime());

	}
}
