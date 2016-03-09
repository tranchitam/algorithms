package com.tctam.algorithms.dynamicprogramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.tctam.algorithms.utils.InputReader;

/*
 5 9
 3 4
 4 5
 5 6
 2 3
 1 1
 */
public class Knapsack {
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
            int f[][] = new int[n + 1][m + 1];
            int x[][] = new int[n + 1][m + 1];

            int g[] = new int[n + 1];
            int v[] = new int[n + 1];
            g[0] = 0;
            v[0] = 0;

            for (int i = 1; i <= n; i++) {
                g[i] = in.nextInt();
                v[i] = in.nextInt();
            }

            for (int i = 0; i <= n; i++) {
                f[i][0] = 0;
                x[i][0] = 0;
            }

            for (int j = 1; j <= m; j++) {
                for (int i = 1; i <= n; i++) {
                    f[i][j] = f[i - 1][j - 0 * g[i]] + 0 * v[i];
                    x[i][j] = 0;
                    for (int k = 1; k <= j / g[i]; k++) {
                        if (f[i - 1][j - k * g[i]] + k * v[i] > f[i][j]) {
                            f[i][j] = f[i - 1][j - k * g[i]] + k * v[i];
                            x[i][j] = k;
                        }
                    }
                }
            }

            out.println(String.format("Maximum value %s", f[n][m]));

            int mm = m;
            for (int i = n; i >= 1; i--) {
                int k = x[i][mm];
                mm = mm - k * g[i];
                out.println(String.format("Take %d package %d, weight: %d", k, i, mm));
            }
        }
    }
}
