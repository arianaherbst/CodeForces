import java.util.*;
/**
 * "Polycarp at the radio"
 * http://codeforces.com/contest/723/problem/C
 * @author Ariana Herbst
 * October 3rd, 2016
 */
public class cfs375C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long[] entries = new long[N];
		int[] counts = new int[M + 1]; //one indexed  
		for (int n = 0; n < N; n++)
		{
			long k = sc.nextInt();
			entries[n] = k;
			if (k <= M)
			{
				counts[(int) k]++;
			}
		}
		
		int target = N / M;
		
		int c = 0;
		ArrayList<Change> queue = new ArrayList<Change>();
		for (int m = 1; m <= M; m++)
		{
			if (counts[m] < target)
				queue.add(new Change(m, target - counts[m]));
		}
		int changes = 0;
		int index = 0;
		for (int n = 0; n < N && !queue.isEmpty(); n++)
		{
			Change k = queue.get(0);
			if (entries[n] > M)
			{
				changes++;
				entries[n] = k.entry;
				k.occurs--;
				counts[k.entry]++;
				if (k.occurs == 0)
					queue.remove(0);
			}
		}
		int i = 0;
		while (!queue.isEmpty())
		{
			Change k = queue.get(0);
			if (counts[(int) entries[i]] > target)
			{
				changes++;
				counts[(int) entries[i]]--;
				entries[i] = k.entry;
				k.occurs--;
				counts[k.entry]++;
				if (k.occurs == 0)
					queue.remove(0);
			}
			i++;
			
			
		}
		System.out.print(target + " " + changes + "\n");
		StringBuilder sb = new StringBuilder();
		for (Long l : entries )
		{
			sb.append(l + " ");
		}
		String ans;
		if (sb.length() > 0)
			ans = sb.substring(0, sb.length() - 1);
		else
			ans = sb.toString();
		System.out.print(ans);

	}
	
	static class Change
	{
		int entry;
		int occurs;
		
		public Change(int e, int o)
		{
			entry = e;
			occurs = o;
		}
		
	}

}
