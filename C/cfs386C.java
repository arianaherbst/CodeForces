import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;


public class cfs386C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int S = sc.nextInt();
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int P = sc.nextInt();
		int D = sc.nextInt();
		double A = Math.abs(x2 - x1) * t2;
		double t = 0;
		double igPos = x1;
		int igDir = x2 > x1 ? 1 : -1;
		if (t1 < t2)
		{
			for (int i = 0; i < 3 && t < A; i++)
			{
				if (igPos * igDir + -1 * D * P >= 0) 	//if train will reach igPos
				{

					double timeElapsed = Math.abs(igPos - P) * 1.0 /( 1.0 /t1 - 1.0/ t2);
					double distElapsedIg = timeElapsed / t2;
					double newTime = timeElapsed + t + (Math.abs(x2 - igPos) - distElapsedIg) * t1;
					if (newTime < A)
					{	
						if (newTime % 1 > 0)
							System.out.println(newTime);
						else
							System.out.printf("%d", (int) (newTime));
						System.exit(0);
					}
					else	{
						System.out.println(((int) A) );
						System.exit(0);
					}
				}

				double dt = i == 0 ? D == -1 ? P / t1 : (S - P) / t1 : S / t1;
				t += dt;
				P = D == -1 ? 0 : S;
				D *= -1;
			}

		}
		else
		{
			System.out.println((int)A );
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
