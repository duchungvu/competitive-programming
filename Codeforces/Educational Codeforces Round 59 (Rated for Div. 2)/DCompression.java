package main;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class DCompression {

    int n;
    boolean[][] a;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        a = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = in.next();
            hexToBin(str, i);
        }

        int res = n;

        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] != a[i][j - 1]) {
                    res = gcd(res, cur);
                    cur = 1;
                }
                else
                    cur++;
            }
            res = gcd(res, cur);
        }

        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = 1; j < n; j++) {
                if (a[j][i] != a[j - 1][i]) {
                    res = gcd(res, cur);
                    cur = 1;
                }
                else
                    cur++;
            }
            res = gcd(res, cur);
        }

        out.println(res);
    }

    private void hexToBin(String hex, int row) {
        for (int i = 0; i < n / 4; i++) {
            char c = hex.charAt(i);
            int num = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
            for (int j = 3; j >= 0; j--) {
                a[row][i * 4 + j] = num % 2 == 0 ? false : true;
                num /= 2;
            }
        }
    }

    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
