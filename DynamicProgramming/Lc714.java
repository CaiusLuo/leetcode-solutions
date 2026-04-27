package DynamicProgramming;

/**
 * @author Caius
 * @description Lc714 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * @since Created in 2026/4/27
 */
public class Lc714 {
    /**
     * 主要的变动逻辑是在转变 hold 的操作添加 fee 操作
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int hold = -(prices[0] + fee);
        int nothold = 0;

        for (int i = 1; i < prices.length; i++) {
            int preHold = hold;
            int preNothold = nothold;

            hold = Math.max(preHold, preNothold - prices[i] - fee);
            nothold = Math.max(preNothold, preHold + prices[i]);
        }
        return nothold;
    }
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int ans = maxProfit(prices, 2);
        System.out.println("ans = " + ans);
    }
}
