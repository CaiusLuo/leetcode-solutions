package DynamicProgramming;

/**
 * @author Caius
 * @description Lc312 戳气球
 *
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * @since Created in 2026/4/28
 */
public class Lc312 {
    /**
     * 不是计算第一个气球值多少钱 -- 计算最后一个气球的价值
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        // 初始化 [1, ..., 1] 原始数组左右两边添加 1
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i <= n; i++) val[i] = nums[i - 1];
        int[][] dp = new int[n + 2][n + 2];

        // 遍历区间长度
        for (int len = 2; len <= n + 1; len++) {
            // 遍历左区间的有效部分
            for (int left = 0; left + len <= n + 1; left++) {
                int right = left + len;
                // k 的有效区间是开区间 (left, right)
                for (int k = left + 1; k < right; k++) {
                    // 因为求解 [left, right] 的时候
                    // 只要计算完左区间 [k, left], 右区间 [k, right]
                    // 这时候就剩下 val[left] * val[k] * val[right] 加上就好
                    dp[left][right] = Math.max(
                            dp[left][right],
                            dp[left][k] + dp[k][right] + val[left] * val[k] * val[right]
                    );
                }
            }
        }
        return dp[0][n + 1];
    }
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int ans = maxCoins(nums);
        System.out.println("ans = " + ans);
    }
}
