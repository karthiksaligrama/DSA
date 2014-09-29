package com.example;

public class StringContainingNumbers {

	public boolean validateCompleteString(String s) {
		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			char charecter = c[i];
			System.out.println(charecter);
			if (charecter > 0 && (int) charecter < 9) {
				return false;
			} else {
				continue;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new StringContainingNumbers()
				.validateCompleteString("jhasdkjahskdh1klj"));
	}

}
