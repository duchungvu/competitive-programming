package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BSquaresAndSegments {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = 1;
        int y = 1;
        int s = 1;
        boolean turn = true;
        while (s < n) {
            if (turn) {
                s += y;
                x++;
                turn = false;
            }
            else {
                s += x;
                y++;
                turn = true;
            }
        }
        out.println(x + y);
    }
}
