package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MergeSort extends AbstractSort {

    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        System.out.println(String.format("Sort from %s to %s", lo, hi));
        int mid = (hi + lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
        print(a);
    }

    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        System.out.println(String.format("Merge from %s mid %s to %s", lo, mid, hi));
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Sort s = new MergeSort();
        Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
        s.sort(a);
    }

}
