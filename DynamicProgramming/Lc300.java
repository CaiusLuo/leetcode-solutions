package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc300 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @since Created in 2026-04-26
 */
public class Lc300 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 是否在 i 的范围里面，需要添加长度
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int ans = lengthOfLIS(nums);
        System.out.println("ans = " + ans);
    }
}
