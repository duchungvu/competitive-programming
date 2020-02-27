package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BDivTimesMod {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++) {
            if (n % i == 0)
                res = Math.min(res, k * n / i + i);
        }
        System.out.println(res);
    }
}
