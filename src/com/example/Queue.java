package com.example;

//implementing a queue

public class Queue<T> {
	Node<T> first;
	Node<T> last;

	// create a queue with object
	public Queue(T o) {
		first = new Node<T>();
		first.value = o;
		last = first;
	}

	public void enqueue(T o) {
		/*
		 * Node<T> n = first; while (n.next != null) { n = n.next; }
		 */
		Node<T> newNode = new Node<T>();
		newNode.value = o;
		// n.next = newNode;

		last.next = newNode;
		last = last.next;
	}

	public T dequeue() {
		Node<T> dequeueNode = first;
		first = first.next;
		return dequeueNode.value;
	}

	public static class Node<E> {
		Node<E> next;
		E value;
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>("karthik");
		q.enqueue("ankita");
		q.enqueue("anirudh");
		q.enqueue("shreeram");
		q.enqueue("akash");
		q.enqueue("usha");

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

}