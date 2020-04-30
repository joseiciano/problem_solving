
/*
ID: icianoj1
LANG: JAVA
PROB: namenum
*/
import java.util.*;
import java.io.*;

class namenum {
    static FastScanner in;
    static FastScanner dict;
    static PrintWriter out;
    static HashSet<String> dic;
    static int n;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("namenum.in");
        dict = new FastScanner("dict.txt");
        out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        dic = new HashSet<String>();
        for (int i = 0; i < 4617; i++) {
            dic.add(dict.next());
        }

        n = in.nextInt();
        ArrayList<Character> chars = new ArrayList<>();
        int num = n;
        while (num != 0) {
            int dig = num % 10;
            num = num / 10;
        }

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
