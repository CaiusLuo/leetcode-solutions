package DynamicProgramming;

/**
 * @author Caius
 * @description Lc377 组合总和 Ⅳ
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素排列的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * @since Created in 2026-04-25
 */
public class Lc377 {
    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        // 目标为 0 的时候是 一种组合
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // 总数 当前加上 target - num 的数量
                if(num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        int ans = combinationSum4(nums, target);
        System.out.println("ans = " + ans);
    }
}
