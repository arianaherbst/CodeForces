import java.util.*;
import java.io.*;

/*
 * http://codeforces.com/contest/816/problem/B
 * Codeforces 3419, Problem B: Karen and Coffee
 * Ariana Herbst, 6/17/2017
 */

public class cfs419B {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        FastScanner sc = new FastScanner();
        int N = sc.nextInt();
		int K = sc.nextInt();
		int Q = sc.nextInt();
		ArrayList<Point> points = new ArrayList<Point>();
		for (int n =0; n < N; n++) {
			points.add(new Point(sc.nextInt(), 1, -1));
			points.add(new Point(sc.nextInt()+1, 2, -1));
		}
		for (int q = 0; q < Q; q++) {
			points.add(new Point(sc.nextInt(), -1, q));
			points.add(new Point(sc.nextInt()+1, -2, q));
		}
		int[] queryStart = new int[Q];
		int[] queryEnd = new int[Q];
		Collections.sort(points);
		int count = 0;
		int k = 0;
		int prev = 0;
		boolean inRange = false;
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			if (inRange && k >= K) {
				count += (p.val - prev);
				prev = p.val;
			}
			inRange = (k >= K);
			switch(p.type) {
				case -1:
					queryStart[p.index] = count;
					break;
				case -2:
					queryEnd[p.index] = count;
					break;
				case 1:
					//start of interval
					k++;
					break;
				case 2:
					//end of interval
					k--;
			}
			if (!inRange && k >= K ) {
				prev = p.val;
				inRange = true;
			} else if (inRange && (k < K) && prev != 0) {
				count += (p.val - prev);
				prev = 0;
				inRange = false;
			}
		}
		for (int q = 0; q < Q; q++) {
			sb.append((queryEnd[q] - queryStart[q] )+ "\n");
		}
        System.out.println(sb);
    }

	public static class Point implements Comparable<Point>{
		int val;
		int type;
		int index;
		public Point(int val, int type, int index) {
			this.val = val;
			this.type = type;
			this.index = index;
		}
		public int compareTo(Point p2) {
			int c1 = Integer.compare(this.val, p2.val);
			int c2 = Integer.compare(this.type, p2.type);
			return c1 != 0 ? c1 : c2;
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