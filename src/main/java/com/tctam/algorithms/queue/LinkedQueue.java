package com.tctam.algorithms.queue;

public class LinkedQueue<T> implements Queue<T> {

	private Node first;
	private Node last;

	private class Node {
		T item;
		Node next;
	}

	public void enqueue(T item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
	}

	public T dequeue() {
		if (!isEmpty()) {
			T item = first.item;
			first = first.next;
			if (isEmpty()) {
				last = first;
			}
			return item;
		}
		return null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}

}
