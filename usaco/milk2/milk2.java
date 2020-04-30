/*
ID: icianoj1
LANG: JAVA
PROB: milk2
*/

import java.util.*;
import java.io.*;

class milk2 {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("milk2.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int n = in.nextInt();

        int[][] times = new int[n][2];
        int t = 0;
        int s = (int) 1e10;
        for (int i = 0; i < n; i++) {
            times[i][0] = in.nextInt();
            times[i][1] = in.nextInt();
            if (times[i][1] > t)
                t = times[i][1];
            if (times[i][0] < s)
                s = times[i][0];
        }

        boolean[] timeline = new boolean[t + 1];

        for (int i = 0; i < n; i++) {
            for (int j = times[i][0]; j < times[i][1]; j++)
                timeline[j] = true;
        }

        int max = times[0][1] - times[0][0];
        for (int i = s; i < t; i++) {
            if (timeline[i]) {
                int j = i;
                while (j < t && timeline[j])
                    j++;

                max = Math.max(max, j - i);
                i = j - 1;
            }
        }
        out.print(max + " ");

        max = 0;
        for (int i = s; i < t; i++) {
            if (!timeline[i]) {
                int j = i;
                while (j < t && !timeline[j])
                    j++;

                max = Math.max(max, (j != i) ? Math.abs(j - i) : 1);
                i = j - 1;
            }
        }
        out.println(max);
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
