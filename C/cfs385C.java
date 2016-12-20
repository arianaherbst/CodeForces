import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
public class cfs385C {
	static List<ArrayList<Integer>> graph;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int N = sc.nextInt(); int M = sc.nextInt(); int K = sc.nextInt();
		int[] govs = new int[K];
		for (int k = 0; k < K; k++)
		{
			govs[k] = sc.nextInt() - 1;
		}
		int[] conCount = new int[K];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int n = 0; n < N; n++)
			graph.add(new ArrayList<Integer>());
		for (int m = 0; m < M; m++)
		{
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int conSum = 0;
		int maxCon = 0;
		int maxConIndex = -1;
		for (int k = 0; k < K; k++)
		{
			conCount[k] = getCon(govs[k]);
			conSum += conCount[k];
			maxCon = Math.max(maxCon, conCount[k]);
			if (maxCon == conCount[k])
				maxConIndex = k;
		}
		//for (Integer i : conCount)
			//System.out.print(i + " ");
//		/System.out.println();
		long possCons = 0;
		for (int k = 0; k < K; k++)
		{
			if (maxConIndex != k)
			{
				possCons += (conCount[k] * (conCount[k] - 1)) / 2;				
			}
		}
		int notConnected = N - conSum;
		possCons += (maxCon + notConnected) * (maxCon + notConnected - 1) / 2;
		System.out.println(possCons - M);
	}
	
	public static int getCon(int k)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.add(k);
		Set<Integer> vis = new HashSet<Integer>();
		while (!s.isEmpty())
		{
			int n = s.pop();
			if (!vis.contains(n))
			{
				vis.add(n);
				for (int i : graph.get(n))
				{
					if (!vis.contains(i))
					{
						s.add(i);
					}
					
				}	
			}
		}
		return vis.size();
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
