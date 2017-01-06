import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;
/**
 * "New Year and Hurry"
 * http://codeforces.com/contest/750/problem/A
 * @author Ariana Herbst
 * December 30, 2015
 */
public class Bye2016A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int P = sc.nextInt();
		int K = sc.nextInt();
		int N  = 240;
		N -= K;
		if (N <= 0)
		{
			System.out.println(0);
			System.exit(0);
		}
		int i;
		for (i = 1; i <= 10 && N > 0; i++)
		{
			N -= i* 5;
		}
		i--;
		if (N < 0)
			i--;
		System.out.println(Math.min(i, P));

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
