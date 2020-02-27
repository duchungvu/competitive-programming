package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class ARightLeftCipher {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int n = s.length();
        int i = 0;
        int j = n - 1;
        boolean o = n % 2 == 0;
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        while (i <= j) {
            if (o) {
                sb.append(ch[j]);
                j--;
            }
            else {
                sb.append(ch[i]);
                i++;
            }
            o = !o;
        }
        System.out.println(sb.reverse().toString());
    }
}
