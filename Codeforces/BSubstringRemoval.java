package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BSubstringRemoval {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        final int MODULO = 998244353;
        int n = in.nextInt();
        String s = in.next();
        char[] cha = s.toCharArray();
        int res = 0;
        if (cha[0] == cha[n - 1]) {
            int i = 0;
            int j = n - 1;
            while (cha[i] == cha[0]) i++;
            while (cha[j] == cha[0]) j--;
            for (int k = 0; k < i + 1; k++) {
                res += n - j;
                res %= MODULO;
            }
        } else {
            int i = 0;
            int j = n - 1;
            while (cha[i] == cha[0]) {
                res++;
                i++;
            }
            while (cha[j] == cha[n - 1]) {
                res++;
                j--;
            }
            res++;
            res %= MODULO;
        }
        out.println(res);
    }
}
