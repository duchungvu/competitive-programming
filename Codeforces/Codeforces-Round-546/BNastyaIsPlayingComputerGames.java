package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BNastyaIsPlayingComputerGames {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int res = 0;
        res = k <= n / 2 ? k + n - 2 : 2 * n - k - 1;
        res += 2 * n + 1;
        out.println(res);
    }
}
