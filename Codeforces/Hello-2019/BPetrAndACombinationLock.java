package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BPetrAndACombinationLock {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0)
                    sum += a[j];
                else
                    sum -= a[j];
            }
            if (sum % 360 == 0) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
