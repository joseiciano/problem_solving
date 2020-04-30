/*
ID: icianoj1
LANG: JAVA
PROB: transform
*/

import java.util.*;
import java.io.*;

class transform {
    static FastScanner in;
    static PrintWriter out;
    static int n;
    static boolean[][] m;
    static boolean[][] mp;

    public static void main(String[] args) throws Exception {
        in = new FastScanner("transform.in");
        out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        n = in.nextInt();
        m = new boolean[n][n];
        mp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                m[i][j] = s.charAt(j) == '@';
            }
        }
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                mp[i][j] = s.charAt(j) == '@';
            }
        }

        boolean[][] rot90 = rotate(m);
        boolean[][] rot180 = rotate(rot90);
        boolean[][] rot270 = rotate(rot180);
        boolean[][] comp = flip(m);
        boolean[][] comprot90 = rotate(comp);
        boolean[][] comprot180 = rotate(comprot90);
        boolean[][] comprot270 = rotate(comprot180);

        if (equals(rot90, mp)) {
            out.println("1");
        } else if (equals(rot180, mp)) {
            out.println("2");
        } else if (equals(rot270, mp)) {
            out.println("3");
        } else if (equals(comp, mp)) {
            out.println("4");
        } else if (equals(comprot90, mp) || equals(comprot180, mp) || equals(comprot270, mp)) {
            out.println("5");
        } else if (equals(m, mp)) {
            out.println("6");
        } else {
            out.println("7");
        }
        out.close();
    }

    static boolean[][] rotate(boolean[][] matrix) {
        boolean[][] ret = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][n - i - 1] = matrix[i][j];
            }
        }
        return ret;
    }

    static boolean[][] flip(boolean[][] matrix) {
        boolean[][] ret = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = matrix[i][n - j - 1];
            }
        }

        // for (int i = 0; i < n; i++)
        // System.out.println(Arrays.toString(matrix[i]));
        // System.out.println();

        // for (int i = 0; i < n; i++) {
        // System.out.println(Arrays.toString(ret[i]));
        // }
        return ret;
    }

    static boolean equals(boolean[][] m1, boolean[][] m2) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (m1[i][j] != m2[i][j])
                    return false;
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
