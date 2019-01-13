package main;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BKvassAndTheFairNut {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        long s = in.nextLong();
        long[] a = new long[(int) n];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            min = Math.min(min, a[i]);
        }

        for (int i = 0; i < n; i++) {
            s -= a[i] - min;
        }

        if (s <= 0)
            out.println(min);
        else {
            if (s % n != 0)
                min--;
            min -= (s / n);
            if (min >= 0)
                out.println(min);
            else
                out.println(-1);
        }


    }
}
