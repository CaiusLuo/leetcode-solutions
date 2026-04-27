package DynamicProgramming;

/**
 * @author Caius
 * @description Lc188 买卖股票的最佳时机 IV
 *
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @since Created in 2026/4/27
 */
public class Lc188 {
    /**
     * 只能交易 k 次 实际就是遍历 k 的状态 dp[k + 1][2]
     * 主要的实现逻辑是在对应的 buy -- sell 之间实现求解。dp[k][1]的max num
     * 遍历一遍 price 中间转移状态 dp
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][2];
        // 初始化 k 个状态buy|sell数据
        for (int i = 0; i <= k; i++) {
            // 0 -- buy 1 -- sell
            dp[i][0] = -prices[0];
            dp[i][1] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 上一个 sell 的值购买当前的股票 ｜ 不买
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                // 上一个 buy[同样index的 buy] 的值添加卖出股票价值 ｜ 不卖
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
            }
        }

        return dp[k][1];
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int ans = maxProfit(2, prices);
        System.out.println("ans = " + ans);
    }
}
