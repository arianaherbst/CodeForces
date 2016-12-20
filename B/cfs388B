import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
/**
 * http://codeforces.com/contest/749/problem/B
 * @author Ariana Herbst
 * December 19, 2016
 */

public class cfs388B {
	
	static int[] x, y;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		Point[] p = new Point[3];
		for (int i = 0; i < 3; i++)
		{
			p[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		System.out.println(3);
		for (int i = 0; i < 3; i++)
		{
			int o = (i + 2) % 3;
			int a = i;
			int b = (i + 1) % 3;
			Point k = p[b].add(p[a].sub(p[o]));
			System.out.println(k.x + " " + k.y);
		}
	}
	static class Point
	{
		int x, y;
		public Point(int x, int y)
		{
			this.x = x; this.y = y;
		}
		Point sub(Point that) { return new Point(x - that.x, y - that.y); }
		Point add(Point that)	{ return new Point(x + that.x, y + that.y);	}
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
