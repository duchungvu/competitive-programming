package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class BBuildAContest {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] pool = new int[m + 10];
        int con = 1;
        for (int i = 0; i < m; i++) {
            int x = in.nextInt() - 1;
            a[x]++;
            pool[a[x]]++;
            if (pool[con] == n) {
                out.print(1);
                con++;
            }
            else
                out.print(0);
        }
    }
}
