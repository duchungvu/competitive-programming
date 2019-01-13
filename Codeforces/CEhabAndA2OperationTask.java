package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class CEhabAndA2OperationTask {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int count = 0;
        out.println(n + 1);
        for (int i = n - 1; i >= 0; i--) {
            if ((a[i] + count) % n < i) {
                int tmp = i - ((a[i] + count) % n);
                count += tmp;
                out.println(1 + " " + (i + 1) + " " + tmp);
            } else if ((a[i] + count) % n > i){
                int tmp = n - ((a[i] + count) % n) + i;
                count += tmp;
                out.println(1 + " " + (i + 1) + " " + tmp);
            } else {
                count += n;
                out.println(1 + " " + (i + 1) + " " + n);
            }
        }
        out.println(2 + " " + n + " " + n);
    }
}
