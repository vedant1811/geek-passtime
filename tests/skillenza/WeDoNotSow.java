import java.util.*;
import java.lang.Math;

class WeDoNotSow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        for(int i=1; i <= r; i++) {
            int n = sc.nextInt();
            PriorityQueue<Integer> ins = new PriorityQueue<>(n);
            PriorityQueue<Integer> outs = new PriorityQueue<>(n);

            for(int j=1; j <= n; j++) {
                int t = sc.nextInt();
                int t2 = sc.nextInt();
                ins.add(t);
                outs.add(t2);
            }

            int docks = 0;
            int maxDocks = 0;

            System.out.println(ins.size() + " ");
            while(!ins.isEmpty()) {
              if (ins.peek() == outs.peek()) {

                System.out.println("in" + ins.peek());
              }
                if (ins.peek() < outs.peek()) {
                    docks++;
                    maxDocks = Math.max(docks, maxDocks);
                    ins.poll();
                } else {
                    docks = Math.max(docks - 1, 0);
                    outs.poll();
                }
            }
            System.out.println(maxDocks);
        }
    }
}
