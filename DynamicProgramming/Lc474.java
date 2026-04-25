package DynamicProgramming;

/**
 * @author Caius
 * @description Lc474 一和零
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * @since Created in 2026-04-25
 */
public class Lc474 {
    /**
     * 三维 dp 解法
     * @param strs
     * @param n
     * @param m
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n){
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 0; i < len; i++) {
            int cnt1 = (int) strs[i].chars().filter(sh -> sh == '0').count();
            int cnt2 = strs[i].length() - cnt1;

            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if(j >= cnt1 && k >= cnt2) dp[i + 1][j][k] = Math.max(dp[i][j][k], dp[i][j - cnt1][k - cnt2] + 1);
                    else dp[i + 1][j][k] = dp[i][j][k];
                }
            }
        }
        return dp[len][m][n];
    }

    /**
     * 二维 dp 空间优化 解法
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm1(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int cnt1 = (int) str.chars().filter(sh -> sh == '0').count();
            int cnt2 = str.length() - cnt1;
            for (int i = m; i >= cnt1; i--) {
                for (int j = n; j >= cnt2; j--) {
                    dp[i][j] = Math.max(dp[i - cnt1][j - cnt2] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
//        int maxForm = findMaxForm(strs, m, n);
        int maxForm = findMaxForm1(strs, m, n);
        System.out.println("maxForm = " + maxForm);
    }
}
