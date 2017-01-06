import java.util.*;
import java.io.*;
/**
 * "New Year and North Pole"
 * http://codeforces.com/contest/750/problem/B
 * @author Ariana Herbst
 * December 30, 2016
 */
public class Bye2016B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		Map<String, Integer> dir = new HashMap<String, Integer>();
		dir.put("North", 1);
		dir.put("South", -1);
		dir.put("East", 0);
		dir.put("West", 0);
		int N = sc.nextInt();
		long loc = 0;
		for (int i = 0; i < N; i++)
		{
			int k = sc.nextInt();
			String d = sc.next();
			int mult = dir.get(d);
			if ((loc == 0 && mult != -1) || (loc == -20_000 && mult != 1))
			{
				System.out.println("NO");
				System.exit(0);
			}
			loc += mult * k;
			if (loc > 0 || loc < -20_000)
			{
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println(loc == 0 ? "YES" : "NO");
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
