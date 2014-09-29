package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Tweets {

	List<String> names;

	List<Pattern> namePatterns;

	private void createPattern() {
		namePatterns = new ArrayList<Pattern>();
		for (String s : names) {
			Pattern p = Pattern.compile(".*" + s + ".*");
			namePatterns.add(p);
		}
	}

	public boolean findName(String tweet) {
		for (Pattern p : namePatterns) {
			if (p.matcher(tweet).matches())
				return true;
		}
		return false;
	}

	public void initializeNames() {
		names = new ArrayList<String>();
		names.add("Rahul Gandhi");
		names.add("Himesh Reshammiya");
		names.add("Narendra Modi");
		names.add("Karthik Saligrama");

	}

	public static void main(String[] args) {
		String tweet = "Sadly even Himesh Reshammiya's numbers"
				+ " are looking better than Rahul Gandhi's . #Elections2014";

		Tweets t = new Tweets();
		t.initializeNames();
		t.createPattern();
		System.out.println(t.findName(tweet));
	}

}
