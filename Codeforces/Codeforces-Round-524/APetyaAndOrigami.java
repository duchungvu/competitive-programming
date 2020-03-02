package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class APetyaAndOrigami {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int res = (n * 2) / k + (n * 5) / k + (n * 8) / k;
        if (n * 2 % k != 0)
            res++;
        if (n * 5 % k != 0)
            res++;
        if (n * 8 % k != 0)
            res++;
        out.println(res);
    }
}
