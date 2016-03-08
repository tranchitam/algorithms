package com.tctam.algorithms.shuffling;

import java.util.Random;

import com.tctam.algorithms.sorting.AbstractSort;

@SuppressWarnings({ "rawtypes" })
public class Shuffling extends AbstractSort {

	public void sort(Comparable[] a) {
		throw new UnsupportedOperationException();
	}

	public void shuffle(Comparable[] a) {
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = random.nextInt(i + 1);
			swap(a, i, r);
			print(a);
		}
	}

	public static void main(String[] args) {
		Shuffling s = new Shuffling();
		Comparable[] a = new Integer[] { 0, 1, 2, 3, 4, 5, 5, 7, 9, 9 };
		s.shuffle(a);
	}
}
