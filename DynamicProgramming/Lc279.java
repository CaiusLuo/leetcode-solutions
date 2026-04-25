package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc 279 完全平方数
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * @since Created in 2026-04-25
 */
public class Lc279 {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while(j*j <= i) {
                 dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                 j++;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
//        int ans = numSquares(12);
        int ans = numSquares(13);
        System.out.println("ans = " + ans);
    }
}
