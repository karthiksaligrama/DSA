package com.example;

public class NumberUtils {

	public static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!(c >= 48 && c < 58)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isNumber("asdasd1231"));
		System.out.println(isNumber("123123"));
	}

}
