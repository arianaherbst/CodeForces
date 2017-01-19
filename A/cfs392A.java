import java.io.*;
import java.util.*;
/**
 * "Holiday of Equality"
 * http://codeforces.com/contest/758/problem/A
 * @author Ariana Herbst
 * 1/19/17
 */
public class cfs392A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int[] n = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			n[i] = sc.nextInt();
			max = Math.max(max, n[i]);
		}
		int ans = 0;
		for (int i = 0; i < N; i++)
		{
			ans += max - n[i];
		}
		System.out.println(ans);

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
