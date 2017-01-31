/**
 * Created by Ariana Herbst on 1/31/17.
 */

import java.util.*;
import java.io.*;

/**
 * http://codeforces.com/problemset/problem/761/B
 * Created by Ariana Herbst on 1/31/17
 */
public class cfs394B {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] A = new int[N];
        int[] A2 = new int[N];
        int[] B = new int[N];
        int[] B2 = new int[N];
        for (int n = 0; n < N; n++) {
            A[n] = sc.nextInt();
        }
        for (int n = 0; n < N; n++) {
            B[n] = sc.nextInt();
        }
        for (int n = 1; n < N; n++) {
            A2[n] = A[n] -A[n-1];
        }
        A2[0] = A[0] + (L - A[N - 1]);
        for (int n = 1; n < N; n++) {
            B2[n] = B[n] - B[n-1];
        }
        B2[0] = B[0] + (L - B[N-1]);
        loop:
        for (int i = 0; i < N; i++) {
            for (int n = 0; n < N; n++) {
                if (A2[n] != B2[(i + n)%N])
                    continue loop;
            }
            System.out.println("YES");
            System.exit(0);
        }
        System.out.println("NO");


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
