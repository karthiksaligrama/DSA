package com.example;

//check if tree is bst or not

public class Tree<T extends Comparable<T>> {
	Node<T> rootNode;

	public static <T extends Comparable<T>> boolean isBST(Tree<T> t) {
		Node<T> node = t.rootNode;
		return isBNode(node);
	}

	private static <T extends Comparable<T>> boolean isBNode(Node<T> node) {
		boolean leftIsBst = false;
		boolean rightIsBst = false;

		if (node != null) {
			if (node.leftChild != null) {
				if (node.leftChild.value.compareTo(node.value) <= 0) {
					leftIsBst = isBNode(node.leftChild);
				} else {
					leftIsBst = false;
				}
			} else {
				leftIsBst = true;
			}

			if (node.rightChild != null) {
				if (node.rightChild.value.compareTo(node.value) >= 1) {
					rightIsBst = isBNode(node.leftChild);
				} else {
					rightIsBst = false;
				}
			} else {
				rightIsBst = true;
			}
		}
		return leftIsBst && rightIsBst;
	}

	private static class Node<E extends Comparable<E>> {
		Node<E> leftChild;
		Node<E> rightChild;

		E value;
	}
}