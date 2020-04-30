
/*
ID: icianoj1
LANG: JAVA
PROB: beads
*/
import java.util.*;
import java.io.*;

class beads {
    static int end;

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner("beads.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = in.nextInt();
        String s = in.next();
        int max = 2;

        boolean same = true;
        end = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(0)) {
                same = false;
                break;
            }
        }

        if (same) {
            out.println(s.length());
            out.close();
            return;
        }

        // System.out.println("STRING S = " + s);
        // Go through the following methods for breaking
        for (int i = 0; i < n; i++) {

            // Go left
            int left = goleft(s, n, i, s.charAt(i));

            // Go right
            int right = goright(s, n, i, s.charAt(i));

            // Take max
            int tot = left + right;
            // System.out.println("AT IDX=" + i + " , LEFT = " + left + " , RIGHT = " +
            // right);
            if (tot > max)
                max = tot;
        }

        out.println(max);
        out.close();

    }

    static int goleft(String s, int n, int idx, char cur) {
        // Find first nonwhite
        int nonwhite = idx;
        int res = 1; // min beads on this side is 1
        while (s.charAt(nonwhite) == 'w') {
            if (nonwhite < 0)
                nonwhite = n - 1;

            res++;
            nonwhite--;
            if (nonwhite < 0)
                nonwhite = n - 1;
            // System.out.println("\tgoin left1: res=" + res);
        }

        // System.out.println("\tidx=" + nonwhite);
        // Keep going left from here until we se different bead
        int i = nonwhite - 1;
        cur = s.charAt(nonwhite);
        while (i != nonwhite) {
            if (i < 0)
                i = n - 1;
            if (s.charAt(i) != cur && s.charAt(i) != 'w')
                break;
            res++;
            end = i;
            i--;
            if (i < 0)
                i = n - 1;
        }

        return res;
    }

    static int goright(String s, int n, int idx, char cur) {
        // Find first nonwhite
        int nonwhite = idx + 1 < n ? idx + 1 : 0;
        int res = 1; // min number of beads on this side

        // System.out.println("right starting at " + nonwhite + " " +
        // s.charAt(nonwhite));
        while (s.charAt(nonwhite) == 'w') {
            if (nonwhite == n)
                nonwhite = 0;
            res++;
            nonwhite++;
            if (nonwhite == n)
                nonwhite = 0;
        }

        // Keep going until we see a different bead color
        int i = nonwhite + 1 < n ? nonwhite + 1 : 0;
        cur = s.charAt(nonwhite);
        while (i != end) {
            if (i == n)
                i = 0;
            if (s.charAt(i) != cur && s.charAt(i) != 'w')
                break;
            res++;
            i++;
            if (i == n)
                i = 0;
        }

        return res;
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
