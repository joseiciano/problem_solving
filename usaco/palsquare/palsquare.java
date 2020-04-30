/*
ID: icianoj1
LANG: JAVA
PROB: palsquare
*/

import java.util.*;
import java.io.*;

class palsquare {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("palsquare.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        int B = in.nextInt();

        for (int i = 1; i <= 300; i++) {
            String baseB = go(B, i);
            String squareB = go(B, i * i);

            if (ispali(squareB))
                out.println(baseB + " " + squareB);
        }
        out.close();
    }

    static String go(int B, int n) {
        StringBuilder str = new StringBuilder();

        while (n > 0) {
            str.append(eval(n % B));
            n /= B;
        }

        return new String(str.reverse());
    }

    static char eval(int n) {
        if (n >= 0 && n <= 9)
            return (char) (n + 48);
        else
            return (char) (n - 10 + 65);
    }

    static Boolean ispali(String s) {
        int l = 0;
        int r = s.length();

        // System.out.println("WE IN HERE WITH " + s);
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r - 1)) {
                // System.out.println("\t" + l + " " + r + " FUCKS IT UP");
                return false;
            }

            l++;
            r--;
        }
        // System.out.println("\t" + s + " is a pali");

        return true;
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

    Boolean hasNext() {
        return st.hasMoreElements();
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
