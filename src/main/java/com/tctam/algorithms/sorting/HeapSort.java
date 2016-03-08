package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class HeapSort extends AbstractSort {
	private int N;

	public void sort(Comparable[] a) {
		System.out.println("-----Build max-heap-----");
		N = a.length;
		for (int k = (N - 1) / 2; k >= 0; k--) {
			sink(a, k);
			print(a);
		}

		System.out.println("-----Sort-----");
		for (int k = N - 1; k >= 0; k--) {
			swap(a, 0, N - 1);
			N--;
			sink(a, 0);
			print(a);
		}
	}

	private void sink(Comparable[] a, int k) {
		while (2 * k + 1 <= N - 1) {
			int j = 2 * k + 1;
			if (j < (N - 1) && a[j].compareTo(a[j + 1]) < 0) {
				j++;
			}

			if (a[k].compareTo(a[j]) >= 0) {
				break;
			}
			swap(a, k, j);
			k = j;
		}
	}

	public static void main(String[] args) {
		Sort s = new HeapSort();
		Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
		s.sort(a);
	}
}
