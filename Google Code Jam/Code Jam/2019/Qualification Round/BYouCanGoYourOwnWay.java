package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class BYouCanGoYourOwnWay {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E')
                sb.append('S');
            else
                sb.append('E');
        }
        out.println("Case #" + testNumber + ": " + sb);
    }
}
