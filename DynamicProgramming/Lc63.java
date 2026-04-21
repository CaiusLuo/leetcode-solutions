package DynamicProgramming;

/**
 * @author Caius
 * @description Lc 63 不同路径 II
 *
 * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 *
 * 返回机器人能够到达右下角的不同路径数量。
 *
 * 测试用例保证答案小于等于 2 * 109。
 *
 * @since Created in 2026-04-22
 */
public class Lc63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // 起点存在障碍物 == 路径数量为 0
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) if(obstacleGrid[i][0] == 0) dp[i][0] = 1; else break;
        for (int j = 0; j < m; j++) if(obstacleGrid[0][j] == 0) dp[0][j] = 1; else break;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(obstacleGrid[i][j] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else dp[i][j] = 0;
            }
        }
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int ans = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("ans = " + ans);
    }
}
