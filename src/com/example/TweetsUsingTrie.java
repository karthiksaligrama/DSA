package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TweetsUsingTrie {

	public static class TrieNode {
		private boolean isEnd;

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

		private Character value;

		public Character getValue() {
			return value;
		}

		public void setValue(Character value) {
			this.value = value;
		}

		private HashMap<Character, TrieNode> children;

		public HashMap<Character, TrieNode> getChildren() {
			return children;
		}

		public void setChildren(HashMap<Character, TrieNode> children) {
			this.children = children;
		}

		public TrieNode(Character c) {
			children = new HashMap<Character, TrieNode>();
			value = c;
			isEnd = false;
		}

	}

	public static class Trie {

		TrieNode rootNode;

		public Trie() {
			rootNode = new TrieNode((char) 0);
		}

		public void insert(String s) {
			int length = s.length();
			TrieNode node = rootNode;
			for (int i = 0; i < length; i++) {
				Character c = s.charAt(i);
				HashMap<Character, TrieNode> children = node.getChildren();
				if (children.containsKey(c)) {
					node = children.get(c);
				} else {
					node = new TrieNode(c);
					children.put(c, node);
				}
			}
			node.isEnd = true;
		}

		public boolean search(String s) {
			if (s == null)
				return false;

			int length = s.length();
			TrieNode node = rootNode;

			for (int i = 0; i < length; i++) {
				Character c = s.charAt(i);
				HashMap<Character, TrieNode> children = node.getChildren();
				if (children.containsKey(c)) {
					node = children.get(c);
				} else {
					return false;
				}
			}

			return true;
		}

	}

	public static void main(String[] args) {
		String tweet = "asdfklasjdl aslkdjflsajd lkasjdfljasdflj alkdjflasjdf";

		String[] tweetSplit = tweet.split(" ");

		Trie trie = new Trie();

		for (int i = 0; i < tweetSplit.length; i++) {
			trie.insert(tweetSplit[i]);
		}

		List<String> names = new ArrayList<String>();
		names.add("lkasjdfljasdflj");

		for (String s : names) {
			if (trie.search(s)) {
				System.out.println(s);
			}
		}
	}

}
