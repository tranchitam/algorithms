package com.tctam.algorithms.sorting;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class QuickSort3Way extends AbstractSort {

    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int i = low;
        int lt = low;
        int gt = high;

        Comparable pivot = a[low];
        while (i <= gt) {
            if (a[i].compareTo(pivot) < 0) {
                swap(a, i, lt);
                print(a);
                i++;
                lt++;
            } else if (a[i].compareTo(pivot) > 0) {
                swap(a, i, gt);
                print(a);
                gt--;
            } else {
                i++;
            }
        }

        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
        print(a);
    }

    public static void main(String[] args) {
        Sort s = new QuickSort3Way();
        Comparable[] a = new Integer[] { 9, 2, 4, 7, 5, 5, 3, 9, 0, 1 };
        s.sort(a);
    }
}
