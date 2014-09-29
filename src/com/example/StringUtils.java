package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtils {

	public static boolean isIsomorphicString(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;

		if (s1.length() != s2.length())
			return false;

		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();

		Map<Character, Character> map = new HashMap<Character, Character>();

		int length = s1.length();

		for (int i = 0; i < length; i++) {
			if (map.containsKey(charArray1[i])) {
				if (map.get(charArray1[i]).equals(charArray2[i]))
					continue;
				else
					return false;
			} else {
				if (map.containsValue(charArray2[i]))
					return false;

				map.put(charArray1[i], charArray2[i]);
			}
		}
		return true;
	}

	public static Character[] cStringReverse(Character[] string) {
		int length = string.length;

		length--;
		length--;
		int count = 0;

		while (true) {
			if (length % 2 == 0 && count == (length - count)) {
				break;
			} else if (length % 2 == 1 && count == (length / 2 + 1)) {
				break;
			}
			char tmp = string[length - count];
			string[length - count] = string[count];
			string[count] = tmp;
			count++;
		}

		return string;
	}

	public static boolean areStringAnagrams(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);// nlogn
		Arrays.sort(c2);// nlogn

		return new String(c1).equals(new String(c2));

	}

	public static void main(String[] args) {
		// Character[] c = { 'a', 'n', 'k', 'i', 't', 'a', null };
		// cStringReverse(c);
		// System.out.println(Arrays.toString(c));
		//
		// String[] inputArray = { "the", "quick", "brown", "fox", "summer",
		// "fox", "the", "brown", "fox", "summers", "quick", "quick",
		// "quick", "summer", "fox" };
		//
		// System.out.println("Minimum Distance between (the) and (fox) "
		// + findDistanceBetweenStringInString(inputArray, "the", "fox"));
		// System.out
		// .println("Minimum Distance between (quick) and (fox) "
		// + findDistanceBetweenStringInString(inputArray,
		// "quick", "fox"));

		// char[] list = { 'c', 'f', 'j', 'p', 'v' };
		// char[] target = { 'a', 'c', 'f', 'k', 'v', 'z' };
		//
		// for (char c : target)
		// System.out.println(c + " -> " + find(list, c));

		String s = "karthik";
		System.out.println(s);
		System.out.println(reverseString(s));

	}

	public static Integer findDistanceBetweenStringInString(String[] str,
			String startWord, String endWord) {

		if (str == null || startWord == null || endWord == null)
			return -1;

		int startWordIndex = findIndexOfWordInArray(str, startWord);
		int endWordIndex = findIndexOfWordInArray(str, endWord);

		if (startWordIndex == -1 || endWordIndex == -1)
			return -1;

		if (startWordIndex < endWordIndex)
			return endWordIndex - startWordIndex;

		return -1;
	}

	private static Integer findIndexOfWordInArray(String[] tokenizedString,
			String word) {
		for (int i = 0; i < tokenizedString.length; i++) {
			if (tokenizedString[i].equals(word))
				return i;
		}
		return -1;
	}

	public static char find(char[] list, char c) {
		int left = 0;
		int right = list.length - 1;
		int mid = left + (right - left) / 2;
		char result = list[0];
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (list[mid] == c)
				if (mid < list.length - 1)
					return list[mid + 1];
				else
					return result;

			if (list[mid] < c) {
				left = mid + 1;
			} else {
				right = mid - 1;
				result = list[mid];
			}
		}
		return result;
	}

	public static String reverseString(String input) {
		if (input == null)
			return null;

		char[] inputCharacters = input.toCharArray();

		int inputLength = java.lang.Math.round(input.length() / 2);
		int stringLength = input.length();
		for (int i = 0; i <= inputLength; i++) {
			if (stringLength % 2 == 1 && i == inputLength)
				continue;

			char temp = inputCharacters[stringLength - i - 1];
			inputCharacters[stringLength - i - 1] = inputCharacters[i];
			inputCharacters[i] = temp;
		}
		return new String(inputCharacters);
	}
}