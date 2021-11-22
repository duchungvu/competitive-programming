package ICPC.NADC.Practice;

import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class C {

    class Shield implements Comparable<Shield> {
        int l, u;
        double f;
        
        Shield(int l, int u, double f) {
            this.l = l;
            this.u = u;
            this.f = f;
        }

        @Override
        public int compareTo(Shield o) {
            return this.l - o.l;
        }
    }

    public void solve(Scanner in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();
        Shield[] s = new Shield[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Shield(in.nextInt(), in.nextInt(), in.nextDouble());
        }
        Arrays.sort(s);
        double t = 0;
        for (int i = 0; i < n; i++) {
            t += (s[i].u - s[i].l) * s[i].f;
            if (i == 0)
                t += s[i].l;
            else
                t += s[i].l - s[i - 1].u;
        }
        if (n > 0) t += y - s[n - 1].u;
        if (n > 0)
            out.println(x / t);
        else
            out.println((double) x / (double) y);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C solver = new C();
        solver.solve(in, out);
        out.close();
    }
    
}
