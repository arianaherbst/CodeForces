import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Codeforces Round 352 Problem D/B: Robin Hood
 * http://codeforces.com/problemset/problem/671/B
 * Ariana Herbst, 7/7/2017
 */

public class RobinHood {
    public static long[] money;
    public static long k;
    public static int n;
    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        k = sc.nextLong();
        money = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextLong();
            sum += money[i];
        }
        shuffle(money);
        Arrays.sort(money);
        long A = binarySearchF();
        long B = binarySearchG();
        if (A > B) {
            ans.append(A - B);
        } else {
            ans.append((sum%n== 0) ? 0 : 1);
        }
        System.out.println(ans);
    }

    /*
    Binary search poorest with k as the target
     */
    public static long binarySearchG() {
        long min = money[0];
        long max = min + k + 1000;
        for (int i = 0; i < 100; i++) {
            long y = (max + min)>>1;
            long val = g(y);
            if (val > k) {
                max = y;
            } else {
                min = y;
            }
        }
        long right = f(max);
        long left = f(min);
        if (left <= k && k < right) {
            return max;
        } else {
            return min;
        }
    }

    /*
    Binary search for richest with k as the target
     */
    public static long binarySearchF() {
        long max = money[n-1];
        long min = max - k - 1000;
        for (int i = 0; i < 100; i++) {
            long x = (max + min)>>1;
            long val = f(x);
            if (val < k) {
                max = x;
            } else {
                min = x;
            }
        }
        long right = f(max);
        long left = f(min);
        if (right <= k && k < left) {
            return max;
        } else {
            return min;
        }
    }

    /*
    The amount of money that would need to be given away to make the richest
    person have x dollars (assuming nothing is given to the poor)
     */
    public static long f(long x) {
        int i = n-1;
        long total = 0;
        while(i >= 0 && money[i] > x) {
            total += money[i] - x;
            i--;
        }
        return total;
    }
    /*
    The amount of money that would need to be received to make the poorest
    person have y dollars (assuming that no money is taken from rich)
     */
    public static long g(long y) {
        int j = 0;
        long total = 0;
        while (j < n && money[j] < y ) {
            total += y - money[j];
            j++;
        }
        return total;
    }

    public static void shuffle (long[] arr) {
        Random rnd = ThreadLocalRandom.current();
        long temp;
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }

}
 