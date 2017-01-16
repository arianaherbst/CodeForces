/**
 * "PolandBall and Game"
 * http://codeforces.com/contest/755/problem/B
 * @author Ariana Herbst
 * January 15, 2017
 */

import java.util.*;
import java.io.*;

public class VentureCupB {
    static StringBuilder sb;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int A = sc.nextInt();
        int B = sc.nextInt();
        Set<String> used = new HashSet<String>();
        for (int i = 0; i < A; i++) {
            used.add(sc.next());
        }
        int sharedCount = 0;
        for (int i = 0; i < B; i++) {
            if (used.contains(sc.next()))
                sharedCount++;
        }
        if (sharedCount % 2 == 0)   {
            System.out.println(A > B ? "YES" : "NO");
        }
        else    {
            System.out.println(A >= B ? "YES" : "NO");
        }
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