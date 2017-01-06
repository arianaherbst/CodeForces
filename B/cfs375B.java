import java.util.*;
/**
 * "Text Document Analysis"
 * http://codeforces.com/contest/723/problem/B
 * @author Ariana Herbst
 * October 3rd, 2016
 */
public class cfs375B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		char[] chars = sc.next().toLowerCase().toCharArray();
		int outsidecurr = 0;
		int inside = 0;
		int outside = 0;
		int cur = 0;
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		boolean parenthesis = false;
		boolean isword = false;
		for (Character k : chars)
		{
			if (alpha.contains(k.toString()) && parenthesis)
			{			
				isword = true;
			}
			else if (alpha.contains(k.toString()) && !parenthesis)
			{
				outsidecurr++;
			}
			else if (k == '(')
			{
				parenthesis = true;
				outsidecurr = 0;
			}
			else if (k == ')')
			{
				if (isword)
					inside++;
				isword = false;
				parenthesis = false;
			}
			else if (parenthesis)
			{
				if (isword)
					inside++;
				isword = false;
			}
			else
			{
				outsidecurr = 0;
			}
			outside = Math.max(outside, outsidecurr);
					
		}
		System.out.print(outside + " " + inside);
	}
}
