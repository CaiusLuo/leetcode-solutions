package DynamicProgramming;

/**
 * @author Caius
 * @description
 * @since Created in 2026/4/27
 */
public class Lc123 {
    public static int maxProfit(int[] prices) {
        // 只能交易两次
        int sell1 = 0;
        int buy1 = - prices[0];
        int sell2 = 0;
        int buy2 = - prices[0];

        for(int i = 1; i < prices.length; ++i) {
            // 状态转移 【持有｜不持有】 -- 继续持有 ｜ 抛售
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(prices[i] + buy1, sell1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(buy2 + prices[i], sell2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int ans = maxProfit(prices);
        System.out.println("ans = " + ans);
    }
}
