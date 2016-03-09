package com.tctam.algorithms.dynamicprogramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.tctam.algorithms.utils.InputReader;

/*
 3 11 
 1 3 5
 */
public class MakeChange {
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
            int m = in.nextInt();
            int v[] = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = in.nextInt();
            }

            int min[] = new int[m + 1];
            for (int i = 0; i <= m; i++) {
                min[i] = 9999;
            }
            min[0] = 0;

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    if (v[j] <= i && min[i - v[j]] + 1 < min[i]) {
                        min[i] = min[i - v[j]] + 1;
                    }
                }
            }
            out.println(min[m]);
        }
    }
}