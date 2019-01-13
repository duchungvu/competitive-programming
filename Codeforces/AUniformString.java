package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class AUniformString {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int c = n;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= Math.min(26, k); i++) {
                for (int j = 0; j < c/k; j++) {
                    sb.append((char) (i+96));
                    n--;
                }
            }
            while (n > 0) {
                sb.append((char) (k+96));
                n--;
            }
            System.out.println(sb.toString());
        }
    }
}
