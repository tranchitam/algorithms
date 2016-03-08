package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ShellSort extends AbstractSort {

	public void sort(Comparable[] a) {
		int h = 1;
		while (h < a.length / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < a.length; i++) {
				for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
					swap(a, j, j - h);
					print(a);
				}
			}
			h /= 3;
		}
	}

	public static void main(String[] args) {
		Sort s = new ShellSort();
		Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
		s.sort(a);
	}
}
