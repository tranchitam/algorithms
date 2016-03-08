package com.tctam.algorithms.sorting;

import java.util.Arrays;

@SuppressWarnings({ "rawtypes" })
public abstract class AbstractSort implements Sort {
	protected void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	protected void print(Comparable[] a) {
		System.out.println(Arrays.toString(a));
	}
}
