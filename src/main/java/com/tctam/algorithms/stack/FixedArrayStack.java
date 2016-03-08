package com.tctam.algorithms.stack;

@SuppressWarnings("unchecked")
public class FixedArrayStack<T> implements Stack<T> {
	private int capacity;
	private T[] items;
	private int index;

	public FixedArrayStack(int capacity) {
		this.capacity = capacity;
		items = (T[]) new Object[capacity];
		index = 0;
	}

	public void push(T item) {
		if (index < capacity) {
			items[index++] = item;
		}
	}

	public T pop() {
		if (!isEmpty()) {
			T item = items[index - 1];
			items[--index] = null;
			return item;
		}
		return null;
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public static void main(String[] args) {
		Stack<String> stack = new FixedArrayStack<String>(5);
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}
}
