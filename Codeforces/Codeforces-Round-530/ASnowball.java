package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class ASnowball {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int w = in.nextInt();
        int h = in.nextInt();
        int u1 = in.nextInt();
        int d1 = in.nextInt();
        int u2 = in.nextInt();
        int d2 = in.nextInt();

        for (int i = h; i >= 0; i--) {
            w += i;
            if (i == d1)
                w = Math.max(0, w - u1);
            else if (i == d2)
                w = Math.max(0, w - u2);
        }
        out.println(w);
    }
}
