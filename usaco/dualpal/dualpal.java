
/*
ID: icianoj1
LANG: JAVA
PROB: dualpal
*/
import java.util.*;
import java.io.*;

class dualpal {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("dualpal.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        int N = in.nextInt();
        int S = in.nextInt();

        int numpalis = 0;
        for (int i = S + 1; i <= Integer.MAX_VALUE; i++) {
            if (numpalis == N)
                break;

            // System.out.println("I = " + i);
            int palicheck = 0;
            for (int B = 2; B <= 10; B++) {
                String baseB = go(B, i);
                // System.out.println(i + " IN BASE " + B + " IS = " + baseB);
                if (ispali(baseB)) {
                    palicheck++;
                    // System.out.println("\t" + baseB + " is a pali");
                }
            }

            if (palicheck >= 2) {
                out.println(i);
                numpalis++;
            }
        }

        out.close();
    }

    static String go(int B, int n) {
        StringBuilder str = new StringBuilder();

        while (n > 0) {
            str.append(n % B);
            n /= B;
        }

        return new String(str.reverse());
    }

    static Boolean ispali(String num) {
        int l = 0;
        int r = num.length();

        while (l <= r) {
            if (num.charAt(l) != num.charAt(r - 1))
                return false;

            l++;
            r--;
        }
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
