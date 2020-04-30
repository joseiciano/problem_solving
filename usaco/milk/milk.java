/*
ID: icianoj1
LANG: JAVA
PROB: milk
*/

import java.util.*;
import java.io.*;

class milk {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("milk.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        int n = in.nextInt();
        int m = in.nextInt();

        Integer[][] milk = new Integer[m][2];

        for (int i = 0; i < m; i++) {
            int pi = in.nextInt();
            int ai = in.nextInt();

            milk[i][0] = pi;
            milk[i][1] = ai;
        }

        Arrays.sort(milk, (Integer[] a, Integer[] b) -> {
            return a[0] - b[0];
        });

        // for (int i = 0; i < milk.length; i++)
        // System.out.println(Arrays.toString(milk[i]));

        int cost = 0;
        for (int i = 0; i < milk.length; i++) {
            if (milk[i][1] > n) {
                cost += n * milk[i][0];
                n -= (n);
            } else {
                cost += milk[i][0] * milk[i][1];
                n -= milk[i][1];
            }
        }

        // System.out.println(cost);
        out.println(cost);
        out.close();
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
