package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class ARomanAndBrowser {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        boolean[] c = new boolean[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        int res = 0;
        for (int b = 0; b < n; b++) {
            if (!c[b]) {
                int dif = sum;
                for (int i = b; i < n; i += k) {
                    c[i] = true;
                    dif -= a[i];
                }
                res = Math.max(res, Math.abs(dif));
            }
        }
        out.println(res);
    }
}
