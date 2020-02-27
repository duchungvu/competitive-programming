package main;

import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class CNastyaIsTransposingMatrices {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = in.nextInt();
            }
        }
        int row = 0, col = 0;
        for (int i = 0; i < n + m - 1; i++) {
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();
            int k = col;
            for (int j = row; j >= 0 && k < m; j--) {
                if (map1.containsKey(a[j][k]))
                    map1.put(a[j][k], map1.get(a[j][k]) + 1);
                else
                    map1.put(a[j][k], 1);
                if (map2.containsKey(b[j][k]))
                    map2.put(b[j][k], map2.get(b[j][k]) + 1);
                else
                    map2.put(b[j][k], 1);
                k++;
            }
            if (!map1.equals(map2)) {
                out.println("NO");
                return;
            }
            if (row == n - 1)
                col++;
            else
                row++;
        }
        out.println("YES");

    }
}
