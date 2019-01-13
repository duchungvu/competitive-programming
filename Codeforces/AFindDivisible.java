package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class AFindDivisible {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            out.println(l + " " + l * 2);
            t--;
        }
    }
}
