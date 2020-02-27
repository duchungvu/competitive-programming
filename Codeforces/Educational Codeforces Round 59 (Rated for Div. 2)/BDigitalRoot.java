package main;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class BDigitalRoot {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        while (n > 0) {
            long k = in.nextLong();
            long x = in.nextLong();
            long res = x + 9 * (k - 1);
            out.println(res);
            n--;
        }
    }
}
