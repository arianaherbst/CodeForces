import java.io.*;
import java.util.*;
/**
 * "Gotta Catch 'Em All!"
 * http://codeforces.com/contest/757/problem/A
 * @author Ariana Herbst
 * January 12, 2017
 */
public class CodecraftA {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		char[] s = sc.next().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length; i++)	{
			Integer k = map.get(s[i]);
			map.put(s[i], k == null ? 1 : k + 1); 
		}
		Integer k = map.get('u');
		if (k != null)
			map.put('u', k / 2);
		k = map.get('a');
		if (k != null)
			map.put('a', k / 2);
		char[] str = "Bulbasr".toCharArray();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length; i++)
		{
			k = map.get(str[i]);
			min = k == null ? 0 : Math.min(min, map.get(str[i]));
		}
		System.out.println(min);

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
