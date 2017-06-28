import java.io.*;
import java.util.*;

/**
 * Round 353C: Recycling Bottles
 * http://codeforces.com/problemset/problem/671/A
 * Ariana Herbst, 6/27/2017
 * Greedy
 */

public class cfs352A {
    static double[] bottleToBin;
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        FastScanner sc = new FastScanner();
        Point A = new Point(sc.nextLong(), sc.nextLong());
        Point B = new Point(sc.nextLong(), sc.nextLong());
        Point T = new Point(sc.nextLong(), sc.nextLong());
        int N = sc.nextInt();
        Point[] P = new Point[N];
        for (int n = 0; n < N; n++) {
            P[n] = new Point(sc.nextLong(), sc.nextLong());
        }
        double[] aToBottle = new double[N];
        double[] bToBottle = new double[N];
        bottleToBin = new double[N];
        double total = 0;
        for (int n = 0; n < N; n++) {
            aToBottle[n] = dist(P[n], A);
            bToBottle[n] = dist(P[n], B);
            bottleToBin[n] = dist(P[n], T);
            total += 2 * bottleToBin[n];
        }
        Distance[] aImprovement = new Distance[N];
        Distance[] bImprovement = new Distance[N];
        for (int n = 0; n < N; n++) {
            aImprovement[n] = new Distance(n, bottleToBin[n] - aToBottle[n]);
            bImprovement[n] = new Distance(n, bottleToBin[n] - bToBottle[n]);
        }
        Arrays.sort(aImprovement);
        Arrays.sort(bImprovement);
        double comboImp = Long.MIN_VALUE;
        if (N > 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (aImprovement[i].index != bImprovement[j].index) {
                        comboImp = Math.max(comboImp, aImprovement[i].dist + bImprovement[j].dist);
                    }
                }
            }
        }
        double improvement = Math.max(comboImp, Math.max(aImprovement[0].dist, bImprovement[0].dist));
        total -= improvement;
        ans.append(total);
        System.out.println(ans);
    }

    static double dist(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    static class Distance implements Comparable<Distance> {
        int index;
        double dist;
        public Distance(int i, double b1) {
            index = i;
            dist = b1;
        }
        public int compareTo( Distance b) {
            // sort in reverse order
            return Double.compare(b.dist, dist);
        }

    }

    static class Point {
        long x, y;
        public Point(long x, long y){
            this.x = x; this.y = y;
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
 