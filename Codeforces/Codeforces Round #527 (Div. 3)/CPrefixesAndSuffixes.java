package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;

public class CPrefixesAndSuffixes {

    private int n;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        String[] a = new String[2 * n - 2];
        String[] s = new String[2];
        int c = 0;
        for (int i = 0; i < 2 * n - 2; i++) {
            a[i] = in.next();
            if (a[i].length() == n - 1)
                s[c++] = a[i];
        }
        if (check(s[0] + s[1].charAt(n - 2), a, out))
            return;
        else
            check(s[1] + s[0].charAt(n - 2), a, out);

    }

    private boolean check(String s, String[] a, PrintWriter out) {
        char[] p = new char[2 * n - 2];
        for (int i = 1; i < n; i++) {
            boolean pref = false;
            for (int j = 0; j < 2 * n - 2; j++) {
                if (a[j].length() == i) {
                    if (a[j].equals(s.substring(0, i)) && !pref) {
                        p[j] = 'P';
                        pref = true;
                    } else if (a[j].equals(s.substring(n - i, n))) {
                        p[j] = 'S';
                    } else
                        return false;
                }
            }
        }
        for (int i = 0; i < 2 * n - 2; i++) {
            out.print(p[i]);
        }
        return true;
    }
}
