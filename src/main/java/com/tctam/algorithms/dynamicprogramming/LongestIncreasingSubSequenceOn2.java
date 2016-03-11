package com.tctam.algorithms.dynamicprogramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.tctam.algorithms.utils.InputReader;

/*
 5
 2 7 4 3 8
 * */
public class LongestIncreasingSubSequenceOn2 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solve solve = new Solve();
        solve.solve(in, out);
        out.close();
    }

    static class Solve {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int L[] = new int[n];
            L[0] = 1;
            int max = L[0];
            for (int i = 1; i < n; i++) {
                int m = 0;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        if (m < L[j]) {
                            m = L[j];
                        }
                    }
                }
                L[i] = m + 1;
                if (max < L[i]) {
                    max = L[i];
                }
            }

            out.println(max);
        }
    }
}