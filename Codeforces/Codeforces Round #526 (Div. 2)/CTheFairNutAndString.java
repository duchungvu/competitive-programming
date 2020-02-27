package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class CTheFairNutAndString {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        final int MOD = (int) (1e9 + 7);
        String s = in.next();
        int res = 0;
        int seq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                res += seq + 1;
                res %= MOD;
            }
            else if (s.charAt(i) == 'b') {
                seq = res;
            }
        }
        out.println(res);
    }
}
