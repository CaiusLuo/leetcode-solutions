package DynamicProgramming;

/**
 * @author Caius
 * @description Lc712 两个字符串的最小ASCII删除和
 *
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 *
 * @since Created in 2026-04-20
 */
public class Lc712 {
    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) dp[i][0] = dp[i - 1][0] + (int)s1.charAt(i - 1);
        for (int j = 1; j <= m; j++) dp[0][j] = dp[0][j - 1] + (int)s2.charAt(j - 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j] + (int) s1.charAt(i - 1), dp[i][j - 1] + (int) s2.charAt(j - 1));
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int ans = minimumDeleteSum("delete", "leet");
        System.out.println("ans = " + ans);
    }
}
