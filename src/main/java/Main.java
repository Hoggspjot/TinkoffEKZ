import java.util.*;

public class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {


            int n = scanner.nextInt();
            int k = scanner.nextInt();

            long[] dp = new long[n + 1];
            dp[0] = 1;

            for (int x = 1; x <= n; x++) {
                for (int color = 0; color < k; color++) {
                    for (int s = x; s <= n; s++) {
                        dp[s] = (dp[s] + dp[s - x]) % MOD;
                    }
                }
            }

            System.out.println(dp[n]);
        }
    }
}