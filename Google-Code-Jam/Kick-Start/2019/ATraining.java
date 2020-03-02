package main;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class ATraining {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int p = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] =  in.nextInt();
        }
        Arrays.sort(a);
        int tmp = 0;
        for (int i = 0; i < p; i++) {
            tmp += a[p - 1] - a[i];
        }
        int res = tmp;
        for (int i = p; i < n; i++) {
            tmp += (a[i] - a[i - 1]) * (p - 1) - (a[i - 1] - a[i - p]);
            res = Math.min(res, tmp);
        }
        out.println("Case #" + testNumber + ": " + res);
    }
}
