package main;

import java.util.*;
import java.io.PrintWriter;


public class CYuhaoAndAParenthesis {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int res = 0;
        int n = in.nextInt();
        int[] a = new int[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            if (s.length() > 1 && s.charAt(0) == ')' && s.charAt(s.length() - 1) == '(')
                continue;
            boolean check = true;
            int t = 0;
            int min = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(')
                    t++;
                else
                    t--;
                if (t < 0) {
                    min = Math.min(min, t);
                    check = false;
                }
            }
            if (check || min == t) {
                a[c] = t;
                c++;
            }
        }

        if (c == 0)
            out.println(0);
        else {
            Arrays.sort(a, 0, c);
            int i = 0;
            int j = c - 1;
            while (i < j) {
                while (i < c - 2 && a[i] + a[j] < 0) i++;
                while (j > 0 && a[j] + a[i] > 0) j--;
                if (i < j && a[i] + a[j] == 0) {
                    res++;
                    j--;
                    i++;
                }
            }
            out.println(res);
        }
    }
}
