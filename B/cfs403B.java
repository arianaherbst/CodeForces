/**
 * http://codeforces.com/contest/782/problem/B
 * Created by Ariana Herbst on 3/5/17.
 */

import java.util.*;
import java.io.*;


public class cfs403B {
    static long[] coords, speed;
    static int N;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        coords = new long[N];
        speed = new long[N];
        for (int i = 0; i < N; i++) {
            coords[i] = sc.nextLong();
        }
        for (int i = 0; i < N; i++) {
            speed[i] = sc.nextLong();
        }
        double time = binarySearch();
        System.out.println(time);
    }

    public static double binarySearch() {
        // find upper bound
        double time = 1;
        while (!works(time))    {
            time *= 2;
        }
        // binary search
        double high = time;
        double low = Math.max(0, time / 2.0 - .5);
        double k = -1;
        for (int z = 0; z < 200; z++)
        {
            k = (high + low) / 2.0;
            if (works(k))   {
                high = k;
            } else {
                low = k;
            }
        }
        return k;
    }
    public static boolean works(double T) {
        double left = 0;
        double right = Double.MAX_VALUE / 8;
        double l, r;
        for (int i = 0; i < N; i++)
        {
            l = coords[i] - speed[i] * T;
            r = coords[i] + speed[i] * T;
            if (!intersects(left, right, l, r))
            {
                return false;
            }
            left = Math.max(left, l);
            right = Math.min(right, r);
        }
        return true;
    }
    public static boolean intersects(double a, double b, double x, double y)    {
        if (a < x) {
            return x <= b;
        } else {
            return a <= y;
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
