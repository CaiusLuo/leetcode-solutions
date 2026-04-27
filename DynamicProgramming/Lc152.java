package DynamicProgramming;

/**
 * @author Caius
 * @description Lc152 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 请注意，一个只包含一个元素的数组的乘积是这个元素的值。
 *
 * @since Created in 2026/4/27
 */
public class Lc152 {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxLen = 0;
        for(int i = 1; i < n; ++i){
            // 主要逻辑是否比前一个 dp 的值更大
            // 1. 更大 添加当前数据到 dp
            // 2. 更小 更新 dp 为当前数据
            if(nums[i] * dp[i - 1] > dp[i - 1]) dp[i] = dp[i - 1] * nums[i];
            else dp[i] = nums[i];
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
        int[] nums = {-2,0,-1};
        int ans = maxProduct(nums);
        System.out.println("ans = " + ans);
    }
}
