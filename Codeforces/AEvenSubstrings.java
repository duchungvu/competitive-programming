package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class AEvenSubstrings {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((c[i] - '0') % 2 == 0)
                res += i+1;
        }
        out.println(res);
    }
}
