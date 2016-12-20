import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
/**
 * http://codeforces.com/contest/749/problem/C
 * @author Ariana Herbst
 * December 19, 2016
 */


public class cfs388C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		StringBuilder v = new StringBuilder(sc.next());
		boolean drem;
		boolean rrem;
		int r = 0;
		int d = 0;
		Set<Integer> disenfranchised = new HashSet<Integer>();
		char first;
		do
		{
			drem = false;
			rrem = false;
			for (int i = 0; i < v.length(); i++)
			{
				if (!disenfranchised.contains(i)){
					
					if (v.charAt(i) == 'D')
					{
						if (r > 0)	{
							r--;
							disenfranchised.add(i);
							i--;
						}
						else	{
							d++;
							drem = true;
						}
					}
					else	{	//R
						if (d > 0)	{
							d--;
							disenfranchised.add(i);
							i--;
						}
						else	{
							r++;
							rrem = true;
						}
					}
				}
			}
		} while (drem && rrem);
		System.out.println(drem ? "D" : "R");

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
