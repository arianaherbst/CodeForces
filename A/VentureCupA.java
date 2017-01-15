import java.util.*;
import java.io.*;
/**
 * "PolandBall and Hypothesis"
 * http://codeforces.com/contest/755/problem/A
 * @author Ariana Herbst
 * January 15, 2017
 */
public class VentureCupA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = 1;
        while (true)
        {
            for (int i = 2; i < N * m + 1; i++)
            {
                if ((N * m + 1) % i == 0)
                {
                    System.out.println(m);
                    System.exit(0);
                }
            }

            m++;
        }

    }

}
