import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class J {

    public void solve(Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c == 'B' ? 1 : -1;
        }
        out.println(sum == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        J solver = new J();
        solver.solve(in, out);
        out.close();
    }
    
}
