import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;
/**
 * "Functions Again"
 * Max sub-sum
 * http://codeforces.com/contest/789/problem/C
 * @author Ariana Herbst
 * 3/29/17
 */
public class cfs407C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		long[] arr = new long[N];
		for (int n = 0; n < N; n++)	{
			arr[n] = sc.nextLong();
		}
		long[] diff = new long[N-1];
		for (int n = 0; n < N-1; n++)	{
			diff[n] = Math.abs(arr[n] - arr[n+1]);
		}
		System.out.println(Math.max(maxSub(diff, 0), maxSub(diff, 1)));	
	}
	public static long maxSub(long[] arr, int m)	{
		long maxEndHere = 0;
		long maxSoFar = 0;
		for (int i = m; i < arr.length; i+=2)	{
			maxEndHere = Math.max(0, maxEndHere + arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndHere);
			if (i + 1 < arr.length)
				maxEndHere = Math.max(0, maxEndHere - arr[i+1]);
		}
		return maxSoFar;
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
