/**
 * http://codeforces.com/contest/782/problem/C
 * Created by Ariana Herbst on 3/5/17.
 */

import java.util.*;
import java.io.*;

public class cfs403C {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int N = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++)      {
            graph[i] = new ArrayList<Integer>();
        }
        int[] colors = new int[N];
        int x, y;
        for (int i = 0; i < N-1;i++)    {
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
            graph[x].add(y);
            graph[y].add(x);
        }
        long max = 0;
        int maxInd = 0;
        for (int i = 0; i < N; i++) {
            if (graph[i].size() > max)  {
                max = graph[i].size();
                maxInd = i;
            }
        }

        //BFS
        Queue<QueueItem> queue = new ArrayDeque<QueueItem>();
        queue.add(new QueueItem(maxInd, 1, -1));
        while(!queue.isEmpty()) {
            QueueItem next = queue.poll();
            if (colors[next.index] == 0)   {
                colors[next.index] = next.color;
                int col = 1;
                for (int j : graph[next.index])   {
                    // if unvisited
                    if (colors[j] == 0) {
                        while (col == next.color || col == next.prevCol) {
                            col++;
                        }
                        queue.add(new QueueItem(j, col++, next.color));
                    }
                }
            }
            else {
                System.out.println("If you're reading this the assertion is broken :(");
            }
        }
        System.out.println(max+1);
        for (int c : colors)    {
            System.out.print(c + " ");
        }
    }
    public static class QueueItem   {
        int index;
        int color;
        int prevCol;
        public QueueItem(int index, int color, int prevCol)  {
            this.index = index;
            this.color = color;
            this.prevCol = prevCol;
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
