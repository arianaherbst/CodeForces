import java.io.*;
import java.util.*;
/**
 * "Bash's Big Day"
 * http://codeforces.com/contest/757/problem/B
 * @author Ariana Herbst
 * January 12th, 2017
 */
public class CodecraftB {

	public static void main(String[] args) {
		 FastScanner sc = new FastScanner();
		 int N = sc.nextInt();
		 int[] nums = new int[N];
		 for (int i = 0; i < N; i++)	{
			 nums[i] = sc.nextInt();
		 }
		 Map<Integer, Integer> factors = new HashMap<Integer, Integer>();
		 int[] primes = generatePrimes(100001);
		 int max = 1;
		 for(int i = 0; i < N; i++)
		 {
			 Set<Integer> fac = factor(primes, nums[i]);
			 Iterator<Integer> it = fac.iterator();
			 for (int j = 0; j < fac.size(); j++)
			 {
				 int a = it.next();
				 Integer k = factors.get(a);
				 factors.put(a, k == null ? 1 : k + 1);
				 max = Math.max(max, k == null ? 1 : k + 1);
			 }
		 }
		 System.out.println(max);
	}
	
	static boolean [] seive(int N)	{
		boolean [] a = new boolean[N+1];
		Arrays.fill(a,  true);
		a[0] = a[1] = false;
		for (int p = 2; p * p <= N; p++)
			if (a[p])	{
				for (int m = p * p; m <= N; m += p)
					a[m] = false;
			}
		return a;
		
	}
	
	static int [] generatePrimes(int N)	{
		List<Integer> primes = new ArrayList<Integer>();
		boolean [] isPrime = seive(N);
		for (int i = 0; i <= N; i++)
			if (isPrime[i])
				primes.add(i);
		int [] pa = new int[primes.size()];
		for (int i = 0; i < pa.length; i++)
			pa[i] = primes.get(i);
		return pa;
	}
	
	static Set<Integer> factor(int [] P, int n)	{
		Set<Integer> result = new HashSet<Integer>();
		for (int i = 0; i < P.length; i++)	{
			int p = P[i];
			if (p * p > n) break;
			while (n % p == 0)	{
				result.add(p);
				n /= p;
			}
		}
		if (n != 1) //large prime remainder
			result.add(n);
		return result;
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
