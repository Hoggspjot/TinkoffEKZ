import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] l = new long[n + 1];
        long[] r = new long[n + 1];
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            l[i] = scanner.nextLong();
            r[i] = scanner.nextLong();
            a[i] = scanner.nextLong();
        }

        long maxWater = 0;
        for (int start = 1; start <= n; start++) {
            long water = a[start];
            long leftFlow = l[start];
            long rightFlow = r[start];


            for (int i = start - 1; i >= 1; i--) {
                long canFlow = Math.min(leftFlow, a[i]);
                water += canFlow;
                leftFlow = Math.min(leftFlow - canFlow, l[i]);
                if (leftFlow == 0)
                    break;
            }


            for (int i = start + 1; i <= n; i++) {
                long canFlow = Math.min(rightFlow, a[i]);
                water += canFlow;
                rightFlow = Math.min(rightFlow - canFlow, r[i]);
                if (rightFlow == 0)
                    break;
            }

            maxWater = Math.max(maxWater, water);
        }

        System.out.println(maxWater);
    }
}