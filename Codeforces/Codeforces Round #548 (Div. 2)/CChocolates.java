import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author DHV
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BChocolates solver = new BChocolates();
        solver.solve(1, in, out);
        out.close();
    }

    static class BChocolates {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            long res = 0;
            int tmp = 1000000010;
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] > tmp - 1 && tmp - 1 >= 0)
                    tmp--;
                else if (a[i] <= tmp - 1)
                    tmp = a[i];
                res += tmp;
            }
            out.println(res);
        }

    }
}
 