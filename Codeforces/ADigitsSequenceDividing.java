package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class ADigitsSequenceDividing {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            String s = in.next();
            if ((s.length() == 2) && (s.charAt(0) >= s.charAt(1))) {
                out.println("NO");
            }
            else {
                out.println("YES");
                out.println(2);
                out.println(s.charAt(0) + " " + s.substring(1));
            }
        }
    }
}
