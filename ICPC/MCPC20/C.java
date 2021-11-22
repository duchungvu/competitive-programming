import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class C {

    class Person implements Comparable<Person> {
        int index;
        long time;
        
        Person(int index, long time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            return (int) (this.time - o.time);
        }
    }

    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long res = 0;
        int[] t =  new int[n];
        PriorityQueue<Person> pq = new PriorityQueue<Person>();
        for (int i = 0; i < n; i++) t[i] = in.nextInt();
        Arrays.sort(t);
        for (int i = 0; i < Math.min(n, k); i++) pq.add(new Person(i, t[i]));
        while (n > 0) {
            Person p = pq.poll();
            res = p.time;
            if (t[p.index] == p.time)
                n -= 5;
            else
                n -= 4;
            p.time += t[p.index] * 2;
            pq.add(p);
        }
        out.println(res);
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
