/*
ID: icianoj1 
LANG: JAVA 
PROB: gift1
 */

import java.util.*;
import java.io.*;

class gift1 {
    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("gift1.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        int np = in.nextInt();
        String[] names = new String[np];
        for (int i = 1; i <= np; i++) {
            names[i - 1] = in.next();
        }

        HashMap<String, Integer> debt = new HashMap<>();
        for (int i = 0; i < np; i++) {
            String giver = in.next();
            int money = in.nextInt();
            int recipients = in.nextInt();
            debt.put(giver, debt.getOrDefault(giver, 0) - money + (recipients == 0 ? 0 : (money % recipients)));
            for (int j = 0; j < recipients; j++) {
                String giveto = in.next();
                debt.put(giveto, debt.getOrDefault(giveto, 0) + (recipients == 0 ? 0 : (money / recipients)));
            }
        }
        for (String name : names) {
            out.println(name + " " + debt.get(name));
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