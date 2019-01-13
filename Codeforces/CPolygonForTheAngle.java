package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class CPolygonForTheAngle {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t > 0) {
            boolean found = false;
            int a = in.nextInt();
            for (int i = 0; i < 99824353; i++) {
                if (a * i % 180 == 0 && a * i / 180 <= i - 2) {
                    out.println(i);
                    found = true;
                    break;
                }
            }
            if (!found)
                out.println(-1);
            t--;
        }
    }

}
