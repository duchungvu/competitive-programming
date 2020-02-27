package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class AGennadyAndACardGame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        String[] c = new String[5];
        for (int i = 0; i < 5; i++)
            c[i] = in.next();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 2; k++) {
                    if (s.charAt(i) == c[j].charAt(k)) {
                        out.println("YES");
                        return;
                    }
                }
            }
        }
        out.println("NO");
    }
}
