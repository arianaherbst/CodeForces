import java.io.*;
import java.util.*;
/**
 * "Lesha and Array Splitting"
 * http://codeforces.com/contest/754/problem/A
 * @author Ariana Herbst
 * January 6th, 2017
 *
 */
public class cfs390A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int[] a = new int[N];
		boolean possible = false;
		for (int n = 0; n < N; n++)	{
			a[n] = sc.nextInt();
			if (a[n] != 0)
				possible = true;
		}
		ArrayList<int[]> pairs = new ArrayList<int[]>();
		if (possible)	{
			int l = -1; int r = -1;
			boolean zero = false;
			for (int i = 0; i < N; i++)
			{
				if (a[i] != 0)
				{
					if (zero)
					{
						r = i;
						pairs.add(new int[] { (l + 1), (r + 1) });
						l = -1;	r = -1;
						zero = false;
					}
					else
					{
						if (l != -1 && r != -1)
						{
							pairs.add(new int[] { (l + 1), (r + 1) });
						}
						l = i;	r = i;
					}
				}
				else	{		//a[i] == 0
					zero = true;
					if (l == -1)	{
						l = i;
					}
					else	{
						r = i;
						if (a[l] != 0)
							zero = false;
					}
				}
			}
			if (zero)	{
				pairs.get(pairs.size() - 1)[1] = N ;
				r = -1;	l = -1;
			}
			if ((r != -1) && (l != -1))	{
				int[] p = { (l + 1), (r + 1) };
				pairs.add(p);
			}
			System.out.println("YES");
			System.out.println(pairs.size());
			for (int[] pair : pairs)	{
				System.out.println(pair[0] + " " + pair[1]);
			}

		}
		else	{
			System.out.println("NO");
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
