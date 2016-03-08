package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BubbleSort extends AbstractSort {

	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					swap(a, j, j - 1);
				}
			}
			print(a);
		}
	}

	public static void main(String[] args) {
		Sort s = new BubbleSort();
		Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
		s.sort(a);
	}
}
