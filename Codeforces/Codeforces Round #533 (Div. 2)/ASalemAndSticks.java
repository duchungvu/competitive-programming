package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class ASalemAndSticks {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int t = 1;
        int cost = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] != i)
                    tmp += Math.abs(i - a[j] - 1);
            }
            if (tmp < cost) {
                cost = tmp;
                t = i;
            }
        }
        out.println(t + " " + cost);
    }
}
