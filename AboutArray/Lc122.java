package AboutArray;

/**
 * @author Caius
 * @description AboutArray.Lc122 购买股票的最佳时机 II
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
 *
 * 返回 你能获得的 最大 利润 。
 * @since Created in 2026-03-06
 */
public class Lc122 {
//    ans = 7
//    private int[] prices = new int[]{7,1,5,3,6,4};
//    ans = 4
    private int[] prices = new int[]{1,2,3,4,5};

    /**
     * 主要逻辑 == 贪心算法实现 每一步的最佳收益的汇总实现总体收益最大化
     * 实现方法 == 贪心算法
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        int currentStock = prices[0];
//        int maxProfit = 0;
//        for(int price :prices) {
//            if(price <= currentStock) {
//                currentStock = price;
//            } else {
//                maxProfit += price - currentStock;
//                currentStock = price;
//            }
//        }
//        return maxProfit;
//    }

    /**
     * 实现逻辑 使用动态规划逻辑
     * 主要优化的逻辑就是允许无限制交易次数
     * 所以只需要比较下一个和前一个的数据大小就能进行比较叠加就行
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Lc122 solution = new Lc122();
        int ans = solution.maxProfit(solution.prices);
        System.out.println(ans);
    }
}
