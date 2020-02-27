package main;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BEhabAndSubtraction {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
        int i = 0;
        int p = 0;
        while (p < k) {
            while (i < n && a[i] - count == 0)
                i++;
            if (i == n)
                out.println(0);
            else if (a[i] - count > 0) {
                out.println(a[i] - count);
                count += a[i] - count;
            }

            p++;
        }
    }
}
