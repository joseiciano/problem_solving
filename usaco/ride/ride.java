
/*
ID: icianoj1 
LANG: JAVA 
TASK: ride
 */
import java.util.*;
import java.io.*;

public class ride {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("ride.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String comet = in.nextLine();
        String group = in.nextLine();

        int cl = comet.length(), gl = group.length();
        int c = 1;
        int g = 1;
        for (int i = 0; i < cl; i++) {
            c *= comet.charAt(i) - 'A' + 1;
        }
        for (int i = 0; i < gl; i++) {
            g *= group.charAt(i) - 'A' + 1;
        }

        out.println((c % 47 == g % 47) ? "GO" : "STAY");

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