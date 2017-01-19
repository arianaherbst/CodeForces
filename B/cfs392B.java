import java.io.*;
import java.util.*;
/**
 * "Blown Garland"
 * http://codeforces.com/contest/758/problem/B
 * @author Ariana Herbst
 * 1/19/17
 */
public class cfs392B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		char[] s = sc.next().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int[] c= new int[4];
		for (int i = 0; i < s.length; i++)	{
			if (s[i] == '!')	{
				c[i%4]++;
			}
			else	{
				map.put(s[i], i % 4);
			}
		}
		System.out.println(c[map.get('R')] + " "
				+ c[map.get('B')] + " "
				+ c[map.get('Y')] + " "
				+ c[map.get('G')]);

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
