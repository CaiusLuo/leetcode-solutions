package DynamicProgramming;

/**
 * @author Caius
 * @description Lc309 买卖股票的最佳时机含冷冻期
 *
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @since Created in 2026/4/27
 */
public class Lc309 {
    /**
     * 主要逻辑 hold -- nothold -- rest 三个状态转换
     * 1. hold 持有股票
     * 2. nothold 卖出股票
     * 3. 当前属于的数值
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int hold = - prices[0];
        int nothold = 0;
        int rest = 0;

        for (int i = 0; i < prices.length; i++) {
            int preHold = hold;
            int preNothold = nothold;
            int preRest = rest;

            hold = Math.max(preRest - prices[i], preHold);
            nothold = preHold + prices[i];
            rest = Math.max(preNothold, preRest);
        }
        return Math.max(nothold, rest);
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int ans = maxProfit(prices);
        System.out.println("ans = " + ans);
    }
}
