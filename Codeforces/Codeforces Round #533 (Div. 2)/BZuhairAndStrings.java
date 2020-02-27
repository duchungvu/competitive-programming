package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class BZuhairAndStrings {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        int[] a = new int[26];
        char[] ch = s.toCharArray();
        int c = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (ch[i] == ch[i - 1])
                c++;
            else {
                a[ch[i - 1] - 97] += c / k;
                c = 1;
            }
        }
        a[ch[n - 1] - 97] += c / k;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, a[i]);
        }
        out.println(res);
    }
}
