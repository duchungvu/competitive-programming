package main;

import java.util.Scanner;
import java.io.PrintWriter;

public class CMashaAndTwoFriends {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextInt();
            long m = in.nextInt();
            long white = (n * m) / 2;
            long black = (n * m) / 2;
            if ((n * m) % 2 != 0)
                white++;
            long x1 = in.nextInt();
            long y1 = in.nextInt();
            long x2 = in.nextInt();
            long y2 = in.nextInt();
            long x3 = in.nextInt();
            long y3 = in.nextInt();
            long x4 = in.nextInt();
            long y4 = in.nextInt();

            long a1 = (x2 - x1 + 1) * (y2 - y1 + 1);
            long a2 = (x4 - x3 + 1) * (y4 - y3 + 1);

            if (a1 % 2 == 0) {
                white += a1 / 2;
                black -= a1 / 2;
            }
            else {
                if (x1 % 2 == y1 % 2) {
                    white += a1 / 2;
                    black -= a1 / 2;
                } else {
                    white += a1 / 2 + 1;
                    black -= a1 / 2 + 1;
                }
            }
            if (a2 % 2 == 0) {
                white -= a2 / 2;
                black += a2 / 2;
            }
            else {
                if (x3 % 2 != y3 % 2) {
                    white -= a2 / 2;
                    black += a2 / 2;
                } else {
                    white -= a2 / 2 + 1;
                    black += a2 / 2 + 1;
                }
            }
            if (overlap(x1, y1, x2, y2, x3, y3, x4, y4)) {
                long x2Sec = Math.min(x2, x4);
                long x1Sec = Math.max(x1, x3);
                long y2Sec = Math.min(y2, y4);
                long y1Sec = Math.max(y1, y3);

                long a3 = (x2Sec - x1Sec + 1) * (y2Sec - y1Sec + 1);
                if (a3 % 2 == 0) {
                    white -= a3 / 2;
                    black += a3 / 2;
                }
                else{
                    if (x1Sec % 2 == y1Sec % 2) {
                        white -= a3 / 2;
                        black += a3 / 2;
                    } else {
                        white -= a3 / 2 + 1;
                        black += a3 / 2 + 1;
                    }
                }
            }
            out.println(white + " " + black);
        }
    }

    public boolean overlap(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        return !(x1 > x4 || x3 > x2 || y1 > y4 || y3 > y2);
    }
}
