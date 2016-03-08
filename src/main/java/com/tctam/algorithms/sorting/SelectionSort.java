package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SelectionSort extends AbstractSort {

	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
			}
			swap(a, min, i);
			print(a);
		}
	}

	public static void main(String[] args) {
		Sort s = new SelectionSort();
		Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
		s.sort(a);
	}
}
