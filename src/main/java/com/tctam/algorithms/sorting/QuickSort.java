package com.tctam.algorithms.sorting;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class QuickSort extends AbstractSort {

    public void sort(Comparable[] a) {
        int low = 0;
        int high = a.length - 1;
        sort(a, low, high);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable pivot = a[low];

        while (true) {
            while (a[++i].compareTo(pivot) < 0 && i < high)
                ;
            while (pivot.compareTo(a[--j]) < 0 && j > low)
                ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
            print(a);
        }
        swap(a, low, j);
        print(a);
        return j;
    }

    public static void main(String[] args) {
        Sort s = new QuickSort();
        Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
        s.sort(a);

    }
}