package com.tctam.algorithms.stack;

@SuppressWarnings("unchecked")
public class ResizableArrayStack<T> implements Stack<T> {
	private static final int DEFAULT_SIZE = 10;
	private static final int GROW_SIZE = 2;
	private static final int SHRINK_SIZE = 4;
	private T[] items;
	private int index;

	public ResizableArrayStack() {
		items = (T[]) new Object[DEFAULT_SIZE];
		index = 0;
	}

	public void push(T item) {
		if (index == items.length) {
			T[] newItems = (T[]) new Object[items.length * GROW_SIZE];
			System.arraycopy(items, 0, newItems, 0, items.length);
			items = newItems;
		}
		items[index++] = item;
	}

	public T pop() {
		if (!isEmpty()) {
			if (index == items.length / 4) {
				T[] newItems = (T[]) new Object[items.length / SHRINK_SIZE];
				System.arraycopy(items, 0, newItems, 0, items.length / SHRINK_SIZE);
				items = newItems;
			}
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
		Stack<Integer> stack = new ResizableArrayStack<Integer>();
		for (int i = 1; i <= 100; i++) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
