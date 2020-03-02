package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;

public class BParcels {

    int r, c;
    static int[] xm = new int[] {-1, 0, 1, 0};
    static int[] ym = new int[] {0, 1, 0, -1};
    char[][] ch;
    boolean[][] marked;
    int[][] a;
    int maxD;

    private boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }

    private boolean check(int k) {
        int topLeft = r + c - 2;
        int btmRight = 0;
        int topRight = 1 - c;
        int btmLeft = r - 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] > k) {
                    topLeft = Math.min(topLeft, i + j + k);
                    topRight = Math.max(topRight, i - j - k);
                    btmLeft = Math.min(btmLeft, i - j + k);
                    btmRight = Math.max(btmRight, i + j - k);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (ch[i][j] != '1' && topLeft >= i + j && i + j >= btmRight && btmLeft >= i - j && i - j >= topRight)
                    return true;
            }
        }
        return false;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {

        r = in.nextInt();
        c = in.nextInt();
        ch = new char[r][c];
        marked = new boolean[r][c];
        a = new int[r][c];
        maxD = 0;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            ch[i] = in.next().toCharArray();
            for (int j = 0; j < c; j++) {
                if (ch[i][j] == '1') {
                    qx.add(i);
                    qy.add(j);
                    qd.add(0);
                    marked[i][j] = true;
                }
            }
        }

        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            a[x][y] = qd.poll();
            maxD = Math.max(maxD, a[x][y]);
            for (int i = 0; i < 4; i++) {
                int xx = x + xm[i];
                int yy = y + ym[i];
                if (valid(xx, yy) && !marked[xx][yy]) {
                    qx.add(xx);
                    qy.add(yy);
                    qd.add(a[x][y] + 1);
                    marked[xx][yy] = true;
                }
            }
        }

        int left = 0;
        int right = maxD;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid))
                right = mid;
            else
                left = mid + 1;
        }

        out.println("Case #" + testNumber + ": " + left);
    }
}
