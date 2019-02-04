package main;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class CBrutality {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        char[] c = in.next().toCharArray();
        long res = 0;
        PriorityQueue<Long> p = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            p.add(a[i]);
            if (c[i] != c[i + 1]) {
                int t = k;
                while (!p.isEmpty() && t > 0) {
                    res += p.poll();
                    t--;
                }
                p.clear();
            }
        }
        p.add(a[n - 1]);
        int t = k;
        while (!p.isEmpty() && t > 0) {
            res += p.poll();
            t--;
        }

        p.clear();

        out.println(res);
    }
}
