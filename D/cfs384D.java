import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * "Chloe and Pleasant Prizes"
 * http://codeforces.com/problemset/problem/743/D
 * @author Ariana Herbst
 * December 20, 2016
 */
public class cfs384D {

	static int N;
	static long[] gifts;
	static ArrayList<Integer>[] tree;
	static HashSet<Integer> visited;
	static long max2Sum = Long.MIN_VALUE;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		N = sc.nextInt();
		if (N <= 2)	{
			System.out.println("Impossible");
			System.exit(0);
		}
		gifts = new long[N];
		tree = (ArrayList<Integer>[])new ArrayList[N];
		for (int i = 0; i < N; i++)	{
			gifts[i] = sc.nextLong();
			tree[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++)	{
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			tree[u].add(v);
			tree[v].add(u);
		}
		int parent = 0;
		visited = new HashSet<Integer>();
		loop:
			while ((tree[parent].size() < 3 && parent != 0) || (parent == 0 && tree[0].size() == 1))	//connections include parent node
			{
				if (tree[parent].size() == 1 && parent != 0)	{  //no children
					System.out.println("Impossible");
					System.exit(0);
				}
				else	{
					visited.add(parent);
					if (parent != 0)	{
						for (int i = 0; i < 2; i++)	{
							if (!visited.contains(tree[parent].get(i))) {
								parent = tree[parent].get(i);
								continue loop;							
							}
						}
					}
					else
						parent = tree[0].get(0);
				}
			}
		visited.add(parent);
		List<Long> maxSums = new ArrayList<Long>();
		for (int k : tree[parent])	{
			if (!visited.contains(k))	{
				maxSums.add(getMaxSum(k).maxSum);
			}
		}
		long largest = Math.max(maxSums.get(0), maxSums.get(1));
		long secondLargest = Math.min(maxSums.get(0), maxSums.get(1));
		for (int i = 2; i < maxSums.size(); i++)	{
			long sum = maxSums.get(i);
			if (sum > largest )	{
				secondLargest = largest;
				largest = sum;
			}
			else if (sum > secondLargest)	{
				secondLargest = sum;
			}
		}	
		System.out.println(max2Sum > largest + secondLargest ? max2Sum : largest + secondLargest);	
	}


	public static Pair getMaxSum(int index)
	{
		visited.add(index);
		if (tree[index].size() == 1)	{//node is leaf node
			return new Pair(gifts[index], gifts[index]);
		}
		long totalSum = gifts[index];
		long maxSum = Long.MIN_VALUE;
		long maxSum2 = Long.MIN_VALUE;
		boolean notFirst = false;
		for (int i = 0; i < tree[index].size(); i++)	{
			if (!visited.contains(tree[index].get(i)))	{
				Pair sub = getMaxSum(tree[index].get(i));
				totalSum += sub.currSum;
				if (sub.maxSum >= maxSum)	{
					if (notFirst)
						maxSum2 = maxSum;
					notFirst = true;
					maxSum = sub.maxSum;
				}
				else if (notFirst && sub.maxSum > maxSum2)
					maxSum2 = sub.maxSum;
			}
		}
		if (maxSum + maxSum2 > max2Sum && maxSum2 != Long.MIN_VALUE)
			max2Sum = maxSum + maxSum2;
		return new Pair(totalSum, maxSum > totalSum ?  maxSum : totalSum);
	}

	static class Pair
	{
		long currSum, maxSum, maxSum2;
		public Pair(long c, long m)	{
			currSum = c; maxSum = m; 
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