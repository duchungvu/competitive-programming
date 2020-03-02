package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class ASashaAndHisTrip {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int v = in.nextInt();
        int f = 0;
        int res = 0;
        if (n <= v)
            out.println(n - 1);
        else {
            for (int i = 1; i <= n; i++) {
                if (i + f < n) {
                    res += (v - f) * i;
                    f = v;
                }
                f--;
            }
            out.println(res);
        }
    }
}
