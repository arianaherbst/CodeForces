/**
 * "PolandBall and Polygon"
 * http://codeforces.com/contest/755/problem/D
 * @author Ariana Herbst
 * January 15, 2017
 */
import java.util.*;
import java.io.*;

public class VentureCupD {
    static StringBuilder sb;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (K > N / 2)  {
            K = N - K;
        }
        SegmentTree tree = buildTree(1, N);
        sb = new StringBuilder();
        int start = 1;
        int end  = 1 + K;
        boolean endNext = false;
        long count = 1;
        while (true)    {
            count++;
            int i = start + 1;
            if (i > N)  {
                i -= N;
            }
            int j = end + K - 1;
            if (j > N)  {
                j -= N;
            }
            if (j < i)  {
                count += tree.getVal(i , N);
                count += tree.getVal(1, j);
            }
            else {
                count += tree.getVal(i, j);
            }
            if(sb.length() > 10000){
                System.out.print(sb);
                sb = new StringBuilder();
            }
            sb.append(count + " ");
            tree.addVal(end);
            start = end;
            end = end + K;
            if (end > N)
                end -= N;
            if (endNext)    {
                System.out.print(sb);
                System.exit(0);
            }
            if (end == 1) {
                endNext = true;
            }
        }
    }

    public static class SegmentTree {
        SegmentTree m, n;
        int a, b;
        int val;
        public SegmentTree(int a, int b)    {
            this.a = a; this.b = b;
            val = 0;
        }
        public int getVal(int x, int y)
        {
            if (x <= a && y >= b)   {
                return val;
            }
            int newVal = 0;
            if ((y >= a) && (y <= b) || (x <= b) && (x >= a))   {
                newVal += m.getVal(x, y);
                newVal += n.getVal(x, y);
            }
            return newVal;
        }
        public void addVal(int end) {
            val++;
            if (end <= b && end >= a && a != b) {
                if (end <= (a + b) / 2) {
                    m.addVal(end);
                }
                else    {
                    n.addVal(end);
                }
            }
        }
    }

    public static SegmentTree buildTree(int a, int b)
    {
        SegmentTree tree = new SegmentTree(a, b);
        if (a != b)
        {
            SegmentTree childa = buildTree(a, (a + b) / 2);
            tree.m = childa;
            SegmentTree childb = buildTree((a + b) /2 + 1, b );
            tree.n = childb;
        }
        return tree;
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
