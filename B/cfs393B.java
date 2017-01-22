import java.io.*;
import java.util.*;
/**
 * http://codeforces.com/contest/760/problem/B
 * "Frodo and Pillows"
 * @author Ariana Herbst
 * 1/22/17
 */

public class cfs393B {
	static long N, M, K;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		N = sc.nextLong();
		M = sc.nextLong();
		K = sc.nextLong();
		long min = 1;
		long max = M;
		long mid = 1;
		while (max - min > 1)	{
			mid = (max + min) / 2;
			boolean midVal = areEnoughPillows(mid);
			if (midVal)	{
				min = mid;
			}
			else	{
				max = mid;
			}
		}
		System.out.println(areEnoughPillows(max) ? max : min);
	}
	
	static boolean areEnoughPillows(long x)
	{
		long pillowsUsed = N;
		x--;
		pillowsUsed += ((Math.max(1, x - K + 1) + x) * Math.min(K, x)) / 2;
		pillowsUsed += ((Math.max(1, x - N + K) + x - 1) * Math.min(N - K, x - 1)) / 2; 
		return pillowsUsed <= M;
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
