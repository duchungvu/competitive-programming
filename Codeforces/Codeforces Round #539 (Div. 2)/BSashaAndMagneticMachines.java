package main;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BSashaAndMagneticMachines {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i];
        }
        int tmp = res;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 2; j <= (int) Math.sqrt(a[i]); j++) {
                if (a[i] % j == 0) {
                    res = Math.min(res, tmp - a[i] + a[i] / j - a[0] + a[0] * j);
                }
            }
        }
        out.println(res);
    }
}
