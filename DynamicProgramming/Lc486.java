package DynamicProgramming;

/**
 * @author Caius
 * @description Lc486 预测赢家
 *
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * @since Created in 2026/4/28
 */
public class Lc486 {
    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];

        for (int len = 2; len <= n; len++) {
            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;
                dp[left][right] = Math.max(
                        nums[left] - dp[left + 1][right],
                        nums[right] - dp[left][right - 1]
                );
            }
        }
        return dp[0][n - 1] >= 0;
    }
    public static void main(String[] args) {
//        int[] nums = {1,5,233,7};
        int[] nums = {1,5,2};
        boolean ans = predictTheWinner(nums);
        System.out.println("ans = " + ans);
    }
}
