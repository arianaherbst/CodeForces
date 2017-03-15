import java.math.BigInteger;
import java.util.Scanner;
/*
 * http://codeforces.com/contest/785/problem/C
 * Anton and Fairy Tale
 * BinarySearch / Math
 * @author Ariana Herbst
 * 3/15/17
 */
public class cfs404C {
	static BigInteger N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long n = sc.nextLong();
		Long m= sc.nextLong();
		N = new BigInteger(n.toString());
		M = new BigInteger(m.toString());
		if (m <= n)
			N = N.subtract(M);
		else 	{
			System.out.println(N);
			System.exit(0);
		}
		BigInteger day = new BigInteger(M.toString());
		day = day.add(binSearch());
		System.out.println(day.toString());
	}
	
	public static BigInteger binSearch()	{
		BigInteger two = new BigInteger("2");
		BigInteger day = BigInteger.ONE;
		boolean keepGoing = true;
		for (; keepGoing; day = day.add(day))	{
			if ((day.multiply(day.add(BigInteger.ONE))).divide(two).compareTo(N) >= 1)	{
				keepGoing = false;
				continue;
			}
		}
		day = day.divide(two);
		BigInteger low = day.divide(two);
		BigInteger high = new BigInteger(day.toString());
		for (int i = 0; i < 60; i++)	{
			BigInteger check = low.add(high).divide(two);
			if (check.multiply(check.add(BigInteger.ONE)).divide(two).compareTo(N) >= 0)	{
				high = check;
			} else {
				low = check;
			}
		}
		return low.multiply(low.add(BigInteger.ONE)).divide(two).compareTo(N) >= 0 ? low : high;
	}
}
