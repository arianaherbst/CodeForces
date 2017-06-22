import java.util.*;
import java.io.*;

/*
 * Codeforces #419 Problem C: Karen and Game
 * http://codeforces.com/contest/816/problem/C
 * Ariana Herbst, 6/17/2017
 */

public class cfs419C {
    static int N, M;
    static int[][] grid;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        FastScanner sc = new FastScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                grid[n][m] = sc.nextInt();
            }
        }
        int min;
        int count = 0;
        if (N >= M) {
            // more rows than columns, try by columns first
            for (int m = 0; m < M; m++) {
                min = Integer.MAX_VALUE/4;
                for (int n = 0; n < N; n++) {
                    min = Math.min(min, grid[n][m]);
                }
                for (int i = 0; i < min; i++) {
                    sb.append("col " + (m+1) + "\n");
                }
                count += min;
                for (int n = 0; n < N; n++) {
                    grid[n][m] -= min;
                }
            }
        }

        for (int n = 0; n < N; n++) {
            min = Integer.MAX_VALUE/4;
            for (int m = 0; m < M; m++) {
                min = Math.min(min, grid[n][m]);
            }
            for (int i = 0; i < min; i++) {
                sb.append("row " + (n+1) + "\n");
            }
            count += min;
            for (int m = 0; m < M; m++) {
                grid[n][m] -= min;
            }
        }

        if (N < M) {
            for (int m = 0; m < M; m++) {
                min = Integer.MAX_VALUE/4;
                for (int n = 0; n < N; n++) {
                    min = Math.min(min, grid[n][m]);
                }
                for (int i = 0; i < min; i++) {
                    sb.append("col " + (m+1) + "\n");
                }
                count += min;
                for (int n = 0; n < N; n++) {
                    grid[n][m] -= min;
                }
            }
        }
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (grid[n][m] != 0) {
                    sb = new StringBuilder();
                    count = -1;
                }
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }

    
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}