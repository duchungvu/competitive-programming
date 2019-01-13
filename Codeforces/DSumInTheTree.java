package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class DSumInTheTree {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        LinkedList<Integer>[] list = new LinkedList[n];
        long[] a = new long[n];
        long[] p = new long[n];
        for (int i = 0; i < n; i++)
            list[i] = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            int v = in.nextInt();
            list[v - 1].add(i);
        }

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        long res = a[0];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() != 0) {
            int v = queue.poll();
            if (a[v] == -1) {
                if (list[v].size() != 0) {
                    long minVal = Long.MAX_VALUE;
                    for (int i : list[v]) {
                        minVal = Math.min(minVal, a[i]);
                    }

                    if (minVal < p[v]) {
                        out.println(-1);
                        return;
                    } else {
                        a[v] = minVal;
                        res += a[v] - p[v];
                    }

                    for (int i : list[v]) {
                        p[i] = a[v];
                        res += a[i] - minVal;
                        queue.add(i);
                    }
                }
            } else {
                for (int i : list[v]) {
                    p[i] = a[v];
                    queue.add(i);
                }
            }
        }
        out.println(res);
    }
}
