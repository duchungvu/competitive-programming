package main;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BTeamsForming {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        Arrays.sort(a);
        int res = 0;
        for (int i = 1; i < n; i+=2) {
            res += a[i] - a[i-1];
        }
        System.out.println(res);
    }
}
