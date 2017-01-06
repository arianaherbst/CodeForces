import java.util.*;
public class cfs379A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int a = 0;
		int d = 0;
		for (int n = 0; n < N; n++)
		{
			if (c[n] == 'A')
				a++;
			if (c[n] == 'D')
				d++;
		}
		if (a > d)
			System.out.print("Anton");
		else if (d > a)
			System.out.print("Danik");
		else
			System.out.print("Friendship");
	}

}
