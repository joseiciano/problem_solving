/*
ID: icianoj1
LANG: JAVA
PROB: barn1
*/

import java.util.*;
import java.io.*;

class barn1 {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("barn1.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        int m = in.nextInt(); // max no. board
        int s = in.nextInt(); // no. stalls
        int c = in.nextInt(); // no. occupied stalls

        int[] stalls = new int[s];
        int[] cows = new int[c];

        for (int i = 0; i < c; i++) {
            stalls[i] = 1;
            cows
        }
        int[] cows = new int[c];
        for (int i = 0; i < c; i++)
            cows[i] = in.nextInt();

        Arrays.sort(cows);

        PriorityQueue<board> stalls = new PriorityQueue<>();
        // ArrayList<board> stalls = new ArrayList<>();
        for (int n : cows) {
            stalls.offer(new board(n, n));
        }

        while (stalls.size() > m) {
        }

        out.close();
    }

}

class board implements Comparable<board> {
    int s; // start
    int e; // end
    int gap; // stalls covering

    public board(int ss, int ee) {
        s = ss;
        e = ee;
        gap = e - s + 1;
    }

    public int compareTo(board b) {
        if (this.gap != b.gap)
            return this.gap - b.gap;
        return this.s - b.s;
    }
}

class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner(String file) throws Exception {
        br = new BufferedReader(new BufferedReader(new FileReader(file)));
    }

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
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

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
