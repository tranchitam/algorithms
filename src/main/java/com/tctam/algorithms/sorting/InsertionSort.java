package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InsertionSort extends AbstractSort {

	public void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			while (j > 0 && a[j].compareTo(a[j - 1]) < 0) {
				swap(a, j, j - 1);
				j--;
			}
			print(a);
		}
	}
	
	public static void main(String[] args) {
		Sort s = new InsertionSort();
		Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
		s.sort(a);
	}
}
