
/*
ID: icianoj1
LANG: JAVA
TASK: test
*/

import java.util.*;
import java.io.*;

class test {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new FileReader("test.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

        tok = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(tok.nextToken());
        int b = Integer.parseInt(tok.nextToken());
        out.println(a + b);
        out.close();
    }
}