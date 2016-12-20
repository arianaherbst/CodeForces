import java.util.*;

public class cfs380A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int n = sc.nextInt();
		String next = sc.next();
		char[] c = next.toCharArray();
		for (int i = 0; i < n; i++)
		{
			boolean print = true;
			//System.out.println(next.substring(i, i + 3));
			if (i + 3 <= n && next.substring(i, i + 3).equals("ogo"))
			{
				print = false;
				int k = i + 3;
				while (k + 2 <= n && next.substring(k, k + 2).equals("go"))
				{
					k += 2;
				}
				ans.append("***");
				i = k - 1;
			}
			if (i < n && print)
				ans.append(c[i]);
		}
		System.out.println(ans);

	}

}
