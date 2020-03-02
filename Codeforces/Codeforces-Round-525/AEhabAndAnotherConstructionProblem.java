package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class AEhabAndAnotherConstructionProblem {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; i * j <= x; j++) {
                if (i * i * j > x) {
                    out.println(i * j + " " + i);
                    return;
                }
            }
        }
        out.println(-1);
    }
}
