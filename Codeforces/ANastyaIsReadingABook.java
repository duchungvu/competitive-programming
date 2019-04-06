package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class ANastyaIsReadingABook {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            in.nextInt();
        }
        int k = in.nextInt();
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] <= k) {
                out.println(n - i);
                break;
            }
        }
    }
}
