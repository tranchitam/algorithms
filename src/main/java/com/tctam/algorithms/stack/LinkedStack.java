package com.tctam.algorithms.stack;

public class LinkedStack<T> implements Stack<T> {

	private Node first;

	private class Node {
		T item;
		Node next;
	}

	public LinkedStack() {
		first = null;
	}

	public void push(T item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	public T pop() {
		if (!isEmpty()) {
			T item = first.item;
			first = first.next;
			return item;
		}
		return null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public static void main(String[] args) {
		Stack<String> stack = new LinkedStack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}
}
