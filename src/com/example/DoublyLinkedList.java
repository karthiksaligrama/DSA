package com.example;

public class DoublyLinkedList<T> {

	private Node<T> header = new Node<T>(null, null, null);

	public DoublyLinkedList() {
		header.next = header.previous = header;
	}

	public void delete(T o) {
		if (o != null) {
			for (Node<T> n = header.next; n != header; n = n.next) {
				if (o.equals(n)) {
					remove(n);
				}
			}
		}
	}

	private void remove(Node<T> n) {
		n.previous.next = n.next;
		n.next.previous = n.previous;
		n.next = n.previous = null;
	}

	private static class Node<T> {
		Node<T> next;
		Node<T> previous;
		T element;

		Node(Node<T> next, Node<T> previous, T element) {
			this.next = next;
			this.previous = previous;
			this.element = element;
		}

	}

}
