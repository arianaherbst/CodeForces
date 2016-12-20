import java.util.*;
public class cfs385A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Set<String> w = new HashSet<String>();
		for (int i = 0; i < s.length(); i++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(s.length() - 1));
			sb.append(s.substring(0, s.length() - 1));
			w.add(sb.toString());
			s = sb.toString();
			
		}
		System.out.println(w.size());
		

	}

}
