import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.StringTokenizer;
/* 
 * http://codeforces.com/contest/785/problem/B
 * Anton and Classes
 * @author Ariana Herbst
 * 3/15/17
 */


public class cfs404B {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		long[] chessS = new long[N];
		long[] chessE = new long[N];
		for (int n = 0; n < N; n++){
			chessS[n] = sc.nextLong();
			chessE[n] = sc.nextLong();
		}
		
		int M = sc.nextInt();
		long[] progS = new long[M];
		long[] progE = new long[M];
		for (int m = 0; m < M; m++)	{
			progS[m] = sc.nextLong();
			progE[m] = sc.nextLong();
		}
		Arrays.sort(chessS);
		Arrays.sort(chessE);
		Arrays.sort(progS);
		Arrays.sort(progE);
		System.out.println(Math.max(Math.max(chessS[N-1] - progE[0], progS[M-1] - chessE[0]), 0));
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
