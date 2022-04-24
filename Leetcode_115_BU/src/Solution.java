import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

        System.out.println(numDistinct("bagbbag", "bag"));
    }

    public static int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()+1][t.length()+1];

        Stream.of(dp).forEach(arr -> {
            Arrays.fill(arr, -1);
        });
        return distinctSubsequenceCount(s, t, s.length(), t.length(), dp);
    }

    private static int distinctSubsequenceCount(String s, String t, int m, int n, int[][] dp) {

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= n ; j++) {
            dp[0][j] = 0;
        }

        for (int a = 1 ;a < m +1; a++) {
            for (int b = 1; b < n+1; b++) {
                if (s.charAt(a-1) == t.charAt(b-1)) {
                    dp[a][b] = dp[a - 1][b - 1] + dp[a - 1][b];
                } else {
                    dp[a][b] = dp[a-1][b];
                }
            }
        }
        return dp[m][n];
    }
}
