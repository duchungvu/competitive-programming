package ICPC.NADC21;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class C {

    class Cell {
        char c;
        boolean checked;
        int left, right, up, down;
        Cell(char c) {
            this.c = c;
            left = 0;
            right = 0;
            up = 0;
            down = 0;
        }
        boolean border() {
            return checked || (left > 0 && right > 0 && up > 0 && down > 0);
        }
        boolean dup() {
            return left > 1 && right > 1 && up > 1 && down > 1;
        }
    }

    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Cell[][] b = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                b[i][j] = new Cell(s.charAt(j));
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // up
                if (i > 0 && b[i][j].c == b[i - 1][j].c) {
                    // b[i][j].up += 1;
                    b[i - 1][j].down += 1;
                }
                // down
                if (i < b.length - 1 && b[i][j].c == b[i + 1][j].c) {
                    // b[i][j].down += 1;
                    b[i + 1][j].up += 1;
                }
                // left
                if (j > 0 && b[i][j].c == b[i][j - 1].c) {
                    // b[i][j].left += 1;
                    b[i][j - 1].right += 1;
                }
                // right
                if (j < b[i].length - 1 && b[i][j].c == b[i][j + 1].c) {
                    // b[i][j].right += 1;
                    b[i][j + 1].left += 1;
                }
            }
        }
        // out.println(b[1][1].left);
        
        int r1 = 0, r2 = b.length - 1;
        int c1 = 0, c2 = b[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                // System.out.println(r1 + "-" + c);
                if (!b[r1][c].border()) {
                    res++;
                    bfs(b, r1, c);
                }
            }
            for (int r = r1 + 1; r <= r2; r++) {
                // System.out.println(r + "-" + c2);
                if (!b[r][c2].border()) {
                    res++;
                    bfs(b, r, c2);
                }
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--){
                    // System.out.println(r2 + "-" + c);
                    if (!b[r2][c].border()) {
                        res++;
                        bfs(b, r2, c);
                    }
                }
                for (int r = r2; r > r1; r--) {
                    // System.out.println(r + "-" + c1);
                    if (!b[r][c1].border()) {
                        res++;
                        bfs(b, r, c1);
                    }
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j].dup()) {
                    // out.println(i + " dup " + j);
                    res--;
                }
            }
        }
        out.println(res);
    }
    
    private void bfs(Cell[][] b, int si, int sj) {
        Queue<Integer> qi = new LinkedList<>();
        Queue<Integer> qj = new LinkedList<>();
        b[si][sj].checked = true;
        qi.add(si);
        qj.add(sj);
        while (!qi.isEmpty()) {
            int i = qi.poll();
            int j = qj.poll();
            // System.out.println(i + " " + j);

            // up
            if (i == 0) {
                b[i][j].up += 1;
            } else if (b[i - 1][j].c == b[i][j].c) {
                if (!b[i - 1][j].checked) {
                    b[i - 1][j].checked = true;
                    qi.add(i - 1);
                    qj.add(j);
                }
            } else {
                b[i - 1][j].down += 1;
                b[i][j].up += 1;
            }

            // down
            if (i == b.length - 1) {
                b[i][j].down += 1;
            } else if (b[i + 1][j].c == b[i][j].c) {
                if (!b[i + 1][j].checked) {
                    b[i + 1][j].checked = true;
                    qi.add(i + 1);
                    qj.add(j);
                }
            } else {
                b[i + 1][j].up += 1;
                b[i][j].down += 1;
            }

            // left
            if (j == 0) {
                b[i][j].left += 1;
            } else if (b[i][j - 1].c == b[i][j].c) {
                if (!b[i][j - 1].checked) {
                    b[i][j - 1].checked = true;
                    qi.add(i);
                    qj.add(j - 1);
                }
            } else {
                b[i][j - 1].right += 1;
                b[i][j].left += 1;
            }

            // right
            if (j == b[i].length - 1) {
                b[i][j].right += 1;
            } else if (b[i][j + 1].c == b[i][j].c) {
                // System.out.println("???");
                if (!b[i][j + 1].checked) {
                    b[i][j + 1].checked = true;
                    qi.add(i);
                    qj.add(j + 1);
                }
            } else {
                b[i][j + 1].left += 1;
                b[i][j].right += 1;
            }
        }
        // System.out.println("--------");
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
