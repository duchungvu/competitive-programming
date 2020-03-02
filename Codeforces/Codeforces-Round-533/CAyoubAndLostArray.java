package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class CAyoubAndLostArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long MOD = (long) (1e9 + 7);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int no = r - l + 1;
        long[][] f = new long[n][3];
        if (no % 3 == 0) {
            for (int i = 0; i < 3; i++) {
                f[0][i] += no / 3;
            }
        }
        else if (no % 3 == 1) {
            f[0][r % 3] = no / 3 + 1;
            f[0][(r % 3 + 1) % 3] = no / 3;
            f[0][(r % 3 + 2) % 3] = no / 3;
        }
        else {
            f[0][r % 3] = no / 3 + 1;
            f[0][(r % 3 + 1) % 3] = no / 3;
            f[0][(r % 3 + 2) % 3] = no / 3 + 1;
        }

        for (int i = 1; i < n; i++) {
            f[i][0] += f[i - 1][0] * f[0][0] % MOD;
            f[i][0] += f[i - 1][1] * f[0][2] % MOD;
            f[i][0] += f[i - 1][2] * f[0][1] % MOD;
            f[i][0] %= MOD;
            f[i][1] += f[i - 1][0] * f[0][1] % MOD;
            f[i][1] += f[i - 1][1] * f[0][0] % MOD;
            f[i][1] += f[i - 1][2] * f[0][2] % MOD;
            f[i][1] %= MOD;
            f[i][2] += f[i - 1][0] * f[0][2] % MOD;
            f[i][2] += f[i - 1][1] * f[0][1] % MOD;
            f[i][2] += f[i - 1][2] * f[0][0] % MOD;
            f[i][2] %= MOD;
        }
        out.println(f[n - 1][0]);
    }

//    modulo inverse
//    private long mod(long a, long m) {
//        a %= m;
//        if (a < 0)
//            a += m;
//        return a;
//    }
//
//    private long inv(long a, long m) {
//        a = mod(a, m);
//        if (a <= 1)
//            return a;
//        return mod((1 - inv(m, a) * m) / a, m);
//    }
}
