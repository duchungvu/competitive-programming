package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class ATheFairNutAndElevator {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += a[i-1] * (Math.abs(j - i) + Math.abs(i - 1) + Math.abs(1 - j)) * 2;
            }
            res = Math.min(res, sum);
        }
        out.println(res);
    }
}
