package DynamicProgramming;

/**
 * @author Caius
 * @description Lc62 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * @since Created in 2026-04-21
 */
public class Lc62 {
    public static int uniquePaths(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) dp[i][1] = 1;
        for (int j = 1; j <= m; j++) dp[1][j] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j- 1];
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int ans = uniquePaths(3, 7);
        System.out.println("ans = " + ans);
    }
}
