package com.example;

import java.util.LinkedList;

public class LinkedListReversal<T> {

	public void reverseLinkedList(LinkedList<T> list) {
		LinkedList<T> tempList = new LinkedList<T>();
		while(!list.isEmpty()){
			tempList.add(list.pop());
		}
		list = tempList;
	}

}
