/**
 * CodeForces Round 414 Problem C: Naming Company
 * Greedy
 * http://codeforces.com/contest/794/problem/C
 * Created by Ariana Herbst on 5/13/17.
 */

import java.util.*;
import java.io.*;

public class cfs414C {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        String strA = sc.next();
        String strB = sc.next();
        int N = strA.length();
        char[] A = strA.toCharArray();
        char[] B = strB.toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);
        A =Arrays.copyOfRange(A, 0, N / 2 + N % 2);
        B = Arrays.copyOfRange(B, N- N/2, N);
        int b = B.length-1;
        int a = 0;
        int bBack = 0;
        int aBack = A.length-1;
        char[] ans = new char[N];
        int front = 0;
        int back = N-1;
        for (int i = 0; i < N; i++) {
            if ((i&1) == 1) { /// lexographically last
                if (a == A.length || B[b] > A[a]) {
                    ans[front++] = B[b--];
                }
                else {
                    ans[back--] = B[bBack++];
                }
            } else {    /// lexographically first

                if ( b == -1 || A[a] < B[b]) {
                    ans[front++] = A[a++];
                }
                else {
                    ans[back--] = A[aBack--];
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        System.out.println(sb);
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
