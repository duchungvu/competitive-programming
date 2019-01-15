package code;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

// BS + Topo

public class EAndrewAndTaxi {
    int n, m, k;
    int[] u, v, c, t;
    boolean[] pm, tm;
    LinkedList<Integer>[] adj;
    int cur;
    boolean cycle = false;
    LinkedList<Integer> res;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        u = new int[m];
        v = new int[m];
        c = new int[m];
        int maxC = 0;
        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            c[i] = in.nextInt();
            maxC = Math.max(maxC, c[i]);
        }

        int l = 0, r = maxC;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid))
                r = mid;
            else
                l = mid + 1;
        }
        check(l);
        out.println(l + " " + k);
        for (int i : res) out.print(i + 1 + " ");

    }

    private boolean check(int lim) {
        res = new LinkedList<>();
        adj = new LinkedList[n + 10];
        pm = new boolean[n + 10];
        tm = new boolean[n + 10];
        t = new int[n + 10];
        cur = 0;
        cycle = false;
        for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (c[i] > lim)
                adj[u[i]].add(v[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!tm[i])
                visit(i);
        }

        if (cycle)
            return false;
        else
            k = 0;

        for (int i = 0; i < m; i++) {
            if (t[u[i]] < t[v[i]] && c[i] <= lim){
                k++;
                res.add(i);
            }
        }

        return true;
    }

    // topo
    private void visit(int u) {
        if (tm[u]) {
            cycle = true;
            return;
        }
        if (cycle)
            return;
        tm[u] = true;
        for (int v : adj[u]) {
            if (!pm[v])
                visit(v);
        }
        pm[u] = true;
        t[u] = cur++;
    }
}
