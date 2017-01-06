import java.util.*;
/**
 * "The New Year: Meeting New Friends"
 * http://codeforces.com/contest/723/problem/A
 * @author Ariana Herbst
 * October 3rd, 2016
 */
public class cfs375A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] k = new int[3];
		k[0] = sc.nextInt();
		k[1] = sc.nextInt();
		k[2] = sc.nextInt();
		int dist = 500;
		for (Integer curr : k)
		{
			int currDist = 0;
			for (Integer b : k)
				currDist += Math.abs(curr -b);
			dist = Math.min(currDist, dist);
		}

		System.out.print(dist);

	}

}
