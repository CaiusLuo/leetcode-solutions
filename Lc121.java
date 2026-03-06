/**
 * @author Caius
 * @description leetcode 121 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @since Created in 2026-03-05
 */
public class Lc121 {

    // [7,6,4,3,1]
    // [7,1,5,3,6,4]
    private int[] prices = new int[]{7,1,5,3,6,4};

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
//        這個解法沒有使用語法糖是直接使用原生的代碼進行編寫的操作
//        int j = 0;
//        int max = 0;
//        for(int i = 1; i < prices.length; ++i) {
//            if(prices[i] < prices[j]) {
//                j = i;
//            } else {
//                int tmp = prices[i] - prices[j];
//                max = tmp > max ? tmp : max;
//            }
//        }
//        return max;

//        使用語法糖以及封裝好的api進行操作
        int minprice = prices[0];
        int ans = 0;
        for(int price: prices) {
            ans = Math.max(ans, price - minprice);
            minprice = Math.min(minprice, price - minprice);
        }
        return ans;
    }
    public static void main(String[] args) {
        Lc121 solution = new Lc121();
        int ans = solution.maxProfit(solution.prices);
        System.out.println(ans);
    }
}
