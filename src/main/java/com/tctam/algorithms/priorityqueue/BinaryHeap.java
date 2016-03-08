package com.tctam.algorithms.priorityqueue;

import java.util.Arrays;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BinaryHeap<T extends Comparable<T>> implements PriorityQueue {

	private T[] a;
	private int N;

	public BinaryHeap(int capacity) {
		a = (T[]) new Comparable[capacity + 1];
		N = 0;
	}

	public void insert(Comparable key) {
		a[++N] = (T) key;
		swim(a, N);
		print(a);
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public T deleteMax() {
		T top = a[1];
		swap(a, 1, N--);
		sink(a, 1);
		a[N + 1] = null;
		print(a);
		return top;
	}

	private void swap(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private void swim(T[] a, int k) {
		while (k > 1 && a[k].compareTo(a[k / 2]) > 0) {
			swap(a, k, k / 2);
			k /= 2;
		}
	}

	private void sink(T[] a, int k) {
		while (k <= N / 2) {
			int j = 2 * k;
			if (j < N && a[j].compareTo(a[j + 1]) < 0) {
				j++;
			}
			if (a[k].compareTo(a[j]) >= 0) {
				break;
			}
			swap(a, k, j);
			k = j;
		}
	}

	private void print(T[] a) {
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		PriorityQueue<String> q = new BinaryHeap<String>(15);
		q.insert("T");
		q.insert("P");
		q.insert("R");
		q.insert("N");
		q.insert("H");
		q.insert("O");
		q.insert("A");
		q.insert("E");
		q.insert("I");
		q.insert("G");

		q.insert("S");
		q.deleteMax();
		q.deleteMax();
		q.insert("S");
	}
}
