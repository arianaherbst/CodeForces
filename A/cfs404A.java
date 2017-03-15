import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * http://codeforces.com/contest/785/problem/A
 * Anton and Polyhedrons
 * @author Ariana Herbst
 * 3/15/17
 */

public class cfs404A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Tetrahedron", 4);
		map.put("Cube",	6);
		map.put("Octahedron", 8);
		map.put("Dodecahedron", 12);
		map.put("Icosahedron", 20);
		long sum = 0;
		for (int n = 0; n < N; n++) {
			sum += map.get(sc.next());
		}
		System.out.println(sum);

	}

}
