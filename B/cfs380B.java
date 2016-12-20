import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cfs380B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] actors = new boolean[N][M];
		int[][] row = new int[2][N];
		int[][] col = new int[2][M];
		Arrays.fill(row[0], -1);
		Arrays.fill(row[1], -1);
		Arrays.fill(col[0], -1);
		Arrays.fill(col[1], -1);
		int[] rowact = new int[N];
		int[] colact = new int[M];
		for (int n = 0; n < N; n++)
		{
			for (int m = 0; m < M; m++)
			{
				int next = sc.nextInt();
				if (next == 1)
				{
					actors[n][m] = true;
					if (row [0][n] == -1)
						row[0][n] = m;
					if (m > row [1][n])
						row[1][n] = m;
					if (col [0][m] == -1)
						col[0][m] = n;
					if (n > col [1][m])
						col[1][m] = n;
					rowact[n]++;
					colact[m]++;
				}
			}
		}
		int count = 0;
		for (int r = 0; r < N; r++)
		{
			if (row[0][r] != -1) 	{
				count += row[0][r];
			}
			if (row[1][r] != -1)	{
				count += M - row[1][r] - 1;
			}
			if (row[0][r] != -1 && row[1][r] != -1)	{
				int temp = 2 * ((row[1][r] - row[0][r] - 1) - (rowact[r] - 2));
				if (temp > 0) { 
					count += temp;
				}
			}
		}
		for (int c = 0; c < M; c++)
		{
			if (col[0][c] != -1)
			{
				count += col[0][c];
			}
			if (col[1][c] != -1)
				count += N - col[1][c] - 1;
			if (col[0][c] != -1 && col[1][c] != -1)	{
				int temp = 2 * ((col[1][c] - col[0][c] - 1) - (colact[c] - 2));
				if (temp > 0 )
					count += temp;
			}
		}
		System.out.println(count);
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