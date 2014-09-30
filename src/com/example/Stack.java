package com.example;

//implementing a stack

public class Stack<T extends Comparable<T>> {

	Node<T> first;

	public void push(T o) {
		Node<T> pushNode = new Node<T>();
		pushNode.value = o;
		pushNode.next = first;

		first = pushNode;
	}

	public T pop() {
		Node<T> popNode = first;
		first = first.next;
		return popNode.value;
	}

	public T peek() {
		Node<T> popNode = first;
		return popNode.value;
	}

	private static class Node<E extends Comparable<E>> {
		Node<E> next;
		E value;
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("qejlqkjer");
		s.push("sdlfkajsd");
		s.push("qweqweq");
		s.push("welrkjwlejr");
		s.push("werweqweqw");
		s.push(",sdmn,mn");

		s.sort();

		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void sort() {
		Stack<T> s = new Stack<T>();
		while (!isEmpty()) {
			T tmp = pop();
			while (!s.isEmpty() && tmp.compareTo(s.peek()) >= 1) {
				push(s.pop());
			}
			s.push(tmp);
		}
		this.first = s.first;
	}

}
