import java.util.Scanner;
/**
 * http://codeforces.com/contest/749/problem/A
 * @author Ariana Herbst
 * December 19, 2016
 */
public class cfs388A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 2;
		int k = N / 2;

		System.out.println(k);
		if (N % 2 == 1)
		{
			System.out.print(3 + " ");
			N-= 3;
		}
		for (i = 0; i < N / 2; i++)
		{
			System.out.print(2 + " ");
		}
	}
}
