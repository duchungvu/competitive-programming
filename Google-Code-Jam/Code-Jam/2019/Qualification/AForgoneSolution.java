package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class AForgoneSolution {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
//        out.println(s);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean rep = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '4') {
                sb1.append('3');
                sb2.append('1');
                rep = true;
            }
            else {
                sb1.append(s.charAt(i));
                if (rep)
                    sb2.append('0');
            }
        }
        out.println("Case #" + testNumber + ": " + sb1 + " " + sb2);
    }
}
