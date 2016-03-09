package com.tctam.algorithms.dynamicprogramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.tctam.algorithms.utils.InputReader;

/*
 16
 2 -4 5 -8 4 -1 -1 1 1 1 -2 2 4 -6 9 -4
 */
public class MaximumValueContiguousSubSequence {
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
            int m[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                m[i] = a[i];
            }
            int p = 0;
            int q = 0;
            int max = m[0];

            for (int i = 1; i < n; i++) {
                if (m[i - 1] > 0) {
                    m[i] = m[i - 1] + a[i];
                } else {
                    p = i;
                    m[i] = a[i];
                }
                if (m[i] > max) {
                    q = i;
                    max = m[i];
                }
            }
            out.println(String.format("%d %d %d", p + 1, q + 1, max));
        }
    }
}
