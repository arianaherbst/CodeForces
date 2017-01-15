/**
 * "PolandBall and Forest"
 * http://codeforces.com/contest/755/problem/C
 * @author Ariana Herbst
 * January 15, 2017
 */

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class VentureCupC {
    static StringBuilder sb;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int N = sc.nextInt();
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++)
        {
            int a = sc.nextInt() - 1;
            uf.union(i, a);
        }
        System.out.println(uf.count);
    }

    public static class UnionFind  {
        int count;
        private int[] id;

        public UnionFind(int numElements)   {
            this.count = numElements;
            id = new int[numElements];
            Arrays.fill(id, -1);
        }

        public int union(int a, int b)  {
            int roota = find(a);
            int rootb = find(b);

            if (roota == rootb) {
                return 0;
            }

            count--;
            if (id[rootb] < id[roota])  {
                id[roota] = rootb;
                return -1;
            }
            else if (id[rootb] > id[roota]) {
                id[rootb] = roota;
            }
            else    {
                id[rootb] = roota;
                id[roota]--;
            }
            return 1;
        }
        public int find(int a)  {
            return id[a] < 0 ? a : (id[a] = find(id[a]));
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
