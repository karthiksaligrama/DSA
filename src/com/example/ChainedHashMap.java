package com.example;

public class ChainedHashMap<X, Y> {

	private Node<X, Y>[] ds;
	private int capacity;

	private int size = 0;

	@SuppressWarnings("unchecked")
	public ChainedHashMap(int capacity) {
		this.capacity = capacity;
		ds = new Node[capacity];
	}

	public ChainedHashMap() {
		this.capacity = 10;
	}

	public void put(X key, Y value) {
		int hash = key.hashCode();

		if (hash < 0)
			hash *= -1;

		Node<X, Y> n = ds[hash % capacity];
		Node<X, Y> newNode = new Node<X, Y>(key, value);

		if (n == null) {
			n = newNode;
			n.lastNode = newNode;
			ds[hash % capacity] = n;
		} else {
			n.lastNode.next = newNode;
			n.lastNode = newNode;
		}
		// } else {
		// n.lastNode = newNode;
		// while (n.next != null) {
		// n = n.next;
		// }
		// n.next = newNode;
		// }

		size++;
		if (size / 2 > capacity) {
			// refactor the hashmap to higher capacity for better O(1)
			// performance
			rehash();
		}
	}

	private void rehash() {
		this.capacity = size * 2;
		Node<X, Y>[] node = ds;
		ds = new Node[capacity];
		for (int i = 0; i < node.length; i++) {
			Node<X, Y> n = node[i];

			while (n != null) {
				put(n.key, n.value);
				n = n.next;
			}
		}
	}

	public Y get(X key) {
		int hash = key.hashCode();

		if (hash < 0)
			hash *= -1;
		Node<X, Y> n = ds[hash % capacity];
		while (n != null) {
			if (n.key.equals(key))
				return n.value;

			n = n.next;
		}
		return null;
	}

	private class Node<T, E> {
		T key;
		E value;
		Node<T, E> next;
		Node<T, E> lastNode;

		public Node(T key, E value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		ChainedHashMap<String, String> map = new ChainedHashMap<String, String>(
				10);

		map.put("xyz", "dfa");
		map.put("abc", "sd");
		map.put("pqr", "asdf");
		map.put("ast", "fgds");
		map.put("lmn", "rtwe");

		System.out.println(map.get("abc"));
		System.out.println(map.get("xyz"));
		System.out.println(map.get("lmn"));

	}

}
