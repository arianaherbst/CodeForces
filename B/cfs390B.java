import java.io.*;
import java.util.*;
/**
 * "Ilya and tic-tac-toe game"
 * http://codeforces.com/contest/754/problem/B
 * @author Ariana Herbst
 * January 6th, 2016
 */

public class cfs390B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int[][] s = new int[4][4];
		//read in input
		for (int i = 0; i < 4; i++)
		{
			char[] next = sc.next().toCharArray();
			for (int j = 0; j < 4; j++)
			{
				switch(next[j])
				{
				case '.':
					s[i][j] = 0;
					break;
				case 'x':
					s[i][j] = 1;
					break;
				case 'o':
					s[i][j] = -1;
					break;				
				}
			}
		}
		//check every location
		for (int r = 0; r < 4; r++)	//row
		{
			for (int c = 0; c < 4; c++)	//column
			{
				if (s[r][c] == 1) {		//there is an 'x' at this location
					//check every direction
					for (int k = 0; k < dir.length; k++)
					{
						int i = r;
						int j = c;
						boolean blank = false;
						boolean x = false;
						for (int z = 0; z < 2; z++)
						{
							i += dir[k][0];
							j += dir[k][1];

							if (i >= 0 && i < 4 && j >= 0 && j < 4) //in bounds
							{
								if (s[i][j] == 0)
									blank = true;
								else if (s[i][j] == 1)
									x = true;
							}
						}
						if (blank && x)
						{
							System.out.println("YES");
							System.exit(0);
						}
					}
				}
			}
		}
		System.out.println("NO");
	}
	static int[][] dir = { 
			{-1, 0}, 
			{1, 0}, 
			{0, 1}, 
			{0, -1},
			{-1, -1},
			{-1, 1},
			{1, -1},
			{1, 1}
	};

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
