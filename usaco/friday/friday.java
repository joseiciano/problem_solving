/*
ID: icianoj1
LANG: JAVA
PROB: friday
*/

import java.util.*;
import java.io.*;

public class friday {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int n = in.nextInt();
        int calendarDays = 0;
        int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] freq = new int[7];

        for (int year = 1900; year < 1900 + n; year++) {
            boolean isLeapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
            for (int month = 0; month < 12; month++) {
                int day = (calendarDays + 12) % 7;
                freq[day]++;
                if (month == 1 && isLeapYear)
                    calendarDays += 29;
                else
                    calendarDays += months[month];
            }
        }

        out.println(freq[5] + " " + freq[6] + " " + freq[0] + " " + freq[1] + " " + freq[2] + " " + freq[3] + " "
                + freq[4]);
        out.close();
    }
}
