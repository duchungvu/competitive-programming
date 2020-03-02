package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class CConnectThree {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int xa = in.nextInt();
        int ya = in.nextInt();
        int xb = in.nextInt();
        int yb = in.nextInt();
        int xc = in.nextInt();
        int yc = in.nextInt();

        if (xa > xb || (xa == xb && ya > yb)) {
            int tmp = xa;
            xa = xb;
            xb = tmp;
            tmp = ya;
            ya = yb;
            yb = tmp;
        }

        if (xa > xc || (xa == xc && ya > yc)) {
            int tmp = xa;
            xa = xc;
            xc = tmp;
            tmp = ya;
            ya = yc;
            yc = tmp;
        }

        if (xb > xc || (xb == xc && yb > yc)) {
            int tmp = xb;
            xb = xc;
            xc = tmp;
            tmp = yb;
            yb = yc;
            yc = tmp;
        }
        out.println(Math.max(ya, Math.max(yb, yc)) - Math.min(ya, Math.min(yb, yc)) + xc - xa + 1);

        for (int i = xa; i < xb; i++)
            out.println(i + " " + ya);
        for (int i = Math.min(ya, Math.min(yb, yc)); i <= Math.max(ya, Math.max(yb, yc)); i++)
            out.println(xb + " " + i);
        for (int i = xb + 1; i <= xc; i++)
            out.println(i + " " + yc);
    }
}
