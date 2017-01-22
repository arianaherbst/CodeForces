import java.io.*;
import java.util.*;
/**
 * http://codeforces.com/contest/760/problem/C
 * "Pavel and Barbecue"
 * @author Ariana Herbst
 * 1/22/17
 */

public class cfs393C{

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt();
		UnionFind uf = new UnionFind(N);
		for (int i = 0; i < N; i++)
		{
			int a = sc.nextInt() - 1;
			uf.union(a, i);
		}
		int count = uf.count == 1 ? 0 : uf.count;
		int sum = 0;
		for (int i = 0; i < N; i++)
		{
			sum += sc.nextInt();
			sum %= 2; 
		}
		count += sum == 0 ? 1 : 0;
		System.out.println(count);
	}
	
	public static class UnionFind  {
        int count;
        private int[] id;

        public UnionFind(int numElements)   {
            this.count = numElements;
            id = new int[numElements];
            Arrays.fill(id, -1);
        }

        public int union(int a, int b)  {
            int roota = find(a);
            int rootb = find(b);

            if (roota == rootb) {
                return 0;
            }

            count--;
            if (id[rootb] < id[roota])  {
                id[roota] = rootb;
                return -1;
            }
            else if (id[rootb] > id[roota]) {
                id[rootb] = roota;
            }
            else    {
                id[rootb] = roota;
                id[roota]--;
            }
            return 1;
        }
        public int find(int a)  {
            return id[a] < 0 ? a : (id[a] = find(id[a]));
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
