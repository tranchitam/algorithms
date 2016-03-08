package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class QuickSelect extends AbstractSort {

    public void sort(Comparable[] a) {
        throw new UnsupportedOperationException();
    }

    public Comparable select(Comparable[] a, int k) {
        int low = 0;
        int high = a.length - 1;
        while (high > low) {
            int j = partition(a, low, high);
            if (k < j) {
                high = j - 1;
            } else if (k > j) {
                low = j + 1;
            } else {
                return a[k];
            }
        }
        return a[k];
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
        }
        swap(a, low, j);
        return j;
    }

    public static void main(String[] args) {
        QuickSelect s = new QuickSelect();
        Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
        int k = 7;
        Comparable kLargest = s.select(a, k);
        System.out.println(String.format("%s largest is %s", k, kLargest));
    }
}
