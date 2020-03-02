package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BMargariteAndTheBestPresent {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int res;
            int l = in.nextInt();
            int r = in.nextInt();
            if (l % 2 == r % 2) {
                res = l + (r - l) / 2;
            } else {
                res = -(r - l + 1) / 2;
            }
            if (l % 2 == 1)
                res = res * -1;
            out.println(res);
        }
    }
}
