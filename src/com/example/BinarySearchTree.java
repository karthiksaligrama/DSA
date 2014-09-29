package com.example;

//implement a binary search tree

public class BinarySearchTree<T extends Comparable<T>> {
	Node<T> rootNode;

	public BinarySearchTree(T rootObject) {
		rootNode = new Node<T>();
		rootNode.value = rootObject;
	}

	public void insert(T o) {
		Node<T> node = null;
		Node<T> parent = rootNode;
		if (o.compareTo(rootNode.value) >= 1) {
			node = rootNode.rightChild;
		} else {
			node = rootNode.leftChild;
		}

		while (node != null) {
			parent = node;
			if (o.compareTo(node.value) >= 1) {
				node = node.rightChild;
			} else {
				node = node.leftChild;
			}
		}

		node = new Node<T>();
		node.value = o;

		if (parent.rightChild == null
				|| o.compareTo(parent.rightChild.value) >= 1) {
			parent.rightChild = node;
		} else {
			parent.leftChild = node;
		}
	}

	public boolean search(T o) {
		Node<T> node = rootNode;

		while (node != null) {
			if (o.compareTo(node.value) == 0) {
				return true;
			} else if (o.compareTo(node.value) >= 1) {
				node = node.rightChild;
			} else if (o.compareTo(node.value) <= 1) {
				node = node.leftChild;
			}
		}
		return false;
	}

	private static class Node<E extends Comparable<E>> {
		Node<E> leftChild;
		Node<E> rightChild;
		E value;
	}

	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<String>("shreeram");
		bst.insert("karthik");
		bst.insert("anirudh");
		bst.insert("usha");
		bst.insert("ankita");
	}
}