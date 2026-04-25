package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc322 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * @since Created in 2026-04-06
 */
public class Lc322 {
    private static int[] coins = {1, 2, 5};
    private static int amount = 11;
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int coin: coins) {
            for(int i = coin; i <= amount; ++i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int ans = coinChange(coins, amount);
        System.out.println("ans = " + ans);
    }
}
