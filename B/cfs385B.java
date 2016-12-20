import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
public class cfs385B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int R = sc.nextInt();
		int C = sc.nextInt();
		boolean[][] board = new boolean[R][C];
		for (int r = 0; r < R; r++)
		{
			char[] next = sc.next().toCharArray();
			for (int c = 0; c < C; c++)
			{
				if (next[c] == 'X')
					board[r][c] = true;
				else
					board[r][c] = false;
			}
		}
		int a = 0;
		int b = 0;
		int x = -1;
		int y = -1;
		loop:
		for (int r = 0; r < R; r++)
		{
			for (int c = 0; c < C; c++)
			{
				if (board[r][c])
				{
					x = r;
					y = c;
					while (c < C && board[r][c])
					{
						c++;
					}
					c--;
					b = c;
					c = y;
					while (r < R && board[r][c])
					{
						r++;
					}
					r--;
					a = r;
					
					
					r += R;
					continue loop;
				}
			}
		}
		//System.out.println(x + " " + y + " " +a + " " + b);
		boolean works = true;
		for (int r = 0; r < R; r++)
		{
			for (int c = 0; c < C; c++)
			{
				
				if (board[r][c] && (!(r >= x && r <= a) || !(c >= y && c <= b)) )
				{
				//	System.out.println(r + " " + c);
					works = false;
				}
				if (!board[r][c] && ((r >= x && r <= a) && (c >= y && c <= b)))
				{
					works = false;
				}
			}
		}
		System.out.println(works ? "YES" : "NO");

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
