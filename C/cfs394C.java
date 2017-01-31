/**
 * http://codeforces.com/contest/761/problem/C
 * Created by Ariana Herbst on 1/31/17.
 */

import java.util.*;
import java.io.*;

/**
 * Created by Ariana Herbst on 1/31/17
 */
public class cfs394C{
    static int[][] board;
    static int N, M;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        for (int n = 0; n < N; n++) {
            char[] c = sc.next().toCharArray();
            for (int m =  0; m < M; m++) {
                if (c[m] >= '0' && c[m] <= '9')
                    board[n][m] = 0;
                else if (c[m] >= 'a' && c[m] <= 'z')
                    board[n][m] = 1;
                else
                    board[n][m] = 2;
            }
        }

        int[][] closest = new int[3][N];
        for (int i = 0; i < 3; i++)
            Arrays.fill(closest[i], M);
        for (int n = 0; n<N; n++)
            for (int m = 0; m < M; m++) {
                closest[board[n][m]][n] =
                    Math.min(closest[board[n][m]][n],
                            Math.min(m, M - m));
            }

        int min = M*3;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (i != j && j != k && i != k)
                        min = Math.min(min, closest[0][i] + closest[1][j] + closest[2][k]);
        System.out.println(min);
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
