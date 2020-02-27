package code;

import java.util.Scanner;
import java.io.PrintWriter;

public class CNNAndTheOpticalIllusion {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        double r = in.nextDouble();
        out.println(r * Math.sin(Math.PI / n) / (1 - Math.sin(Math.PI / n)));
    }
}
