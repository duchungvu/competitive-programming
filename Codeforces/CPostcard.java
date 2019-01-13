package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class CPostcard {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int k = in.nextInt();
        int countQ = 0;
        int countS = 0;
        int countC = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chs[i] == '?')
                countQ++;
            else if (chs[i] == '*')
                countS++;
            else
                countC++;
        }
        if (countC - countQ - countS > k || (countS == 0 && countC < k)) {
            out.println("Impossible");
        }
        else if (countC - countQ - countS <= k && countC >= k) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (chs[i] != '?' && chs[i] != '*') {
                    if (countC > k && (chs[i + 1] == '?' || chs[i + 1] == '*'))
                        countC--;
                    else
                        out.print(chs[i]);
                }
            }
            if (chs[s.length() - 1] != '?' && chs[s.length() - 1] != '*')
                out.print(chs[s.length() - 1]);
        } else {
            int more = k - (countC - countQ - countS);
            for (int i = 0; i < s.length() - 1; i++) {
                if (chs[i] != '?' && chs[i] != '*') {
                    if (chs[i + 1] == '*') {
                        if (countS == 1) {
                            for (int j = 0; j < more; j++)
                                out.print(chs[i]);
                        }
                        countS--;
                    }
                    else if (chs[i + 1] != '?')
                        out.print(chs[i]);
                }
            }
            if (chs[s.length() - 1] != '?' && chs[s.length() - 1] != '*')
                out.print(chs[s.length() - 1]);
        }
    }
}
