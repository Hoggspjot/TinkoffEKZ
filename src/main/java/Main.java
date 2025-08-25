import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int MOD = 1000000007;
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            long[][] dp = new long[n + 1][k + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= Math.min(i, k); j++) {
                    for (int x = 1; x <= i; x++) {
                        if (j >= 1) {
                            dp[i][j] = (dp[i][j] + dp[i - x][j - 1]) % MOD;
                        }
                    }
                }
            }

            long result = dp[n][k];
            System.out.println(result);
        }
    }
}