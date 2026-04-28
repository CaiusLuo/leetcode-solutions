package DynamicProgramming;

/**
 * @author Caius
 * @description Lc877 石子游戏
 *
 * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 *
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
 *
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
 *
 * @since Created in 2026/4/28
 */
public class Lc877 {
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        // 就只剩下一堆石头 获取的差值就是石头本身价值
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];

        for (int len = 2; len <= n; len++) {
            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;
                // 取了一堆石头价值差值
                // 当前石头 - [left + 1, right] | [left, right - 1] 区间最大值
                dp[left][right] = Math.max(
                        piles[left] - dp[left + 1][right],
                        piles[right] - dp[left][right - 1]
                );
            }
        }
        return dp[0][n - 1] > 0;
    }
    public static void main(String[] args) {
        int[] nums = {5,3,4,5};
        boolean ans = stoneGame(nums);
        System.out.println("ans = " + ans);
    }
}
