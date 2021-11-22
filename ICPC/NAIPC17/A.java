package ICPC.NAIPC17;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {

    class Piece implements Comparable<Piece>{
        int sum;
        int close;
        String s;

        Piece(int sum, int close, String s) {
            this.sum = sum;
            this.close = close;
            this.s = s;
        }

        @Override
        public int compareTo(Piece o) {
            return o.sum - this.sum;
        }
    }

    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Piece[] p = new Piece[n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            int sum = 0;
            int close = 0;
            for (char c : s.toCharArray()) {
                sum += c == '(' ? 1 : -1;
                close = Math.min(close, sum);
            }
            p[i] = new Piece(sum, -close, s);
        }
        Arrays.sort(p);
        for (int i = 0; i < n; i++) {
            out.println(p[i].sum + " " + p[i].close + " " + p[i].s);
        }
        int[][] dp = new int[n][n * 400];
        if (p[0].sum >= 0) dp[0][p[0].sum] = p[0].s.length();
        for (int i = 1; i < n; i++) {
            for (int j = Math.max(0, p[i].close); j <= n * 300 - p[i].sum; j++) {
                if (dp[i][j] == 0)
                    dp[i][j] = dp[i - 1][j];
                if (j == 0 || dp[i - 1][j] > 0)
                    dp[i][j + p[i].sum] = dp[i - 1][j] + p[i].s.length();
            }
            // out.println(dp[i][0]);
        }
        out.println(dp[2][1]);

        // int res = 0;
        // for (int i = 0; i < n; i++) {
        //     res = Math.max(dp[i][0], res);
        // }
        // out.println(res);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A solver = new A();
        solver.solve(in, out);
        out.close();
    } 
}
