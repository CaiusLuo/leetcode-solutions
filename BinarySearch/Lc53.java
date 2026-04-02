package BinarySearch;

/**
 * @author Caius
 * @description Lc 53 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 *
 * @since Created in 2026-04-03
 */
public class Lc53 {
    private static int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    public static int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int curMax = globalMax;
        for(int i = 0; i < nums.length; ++i) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
    public static void main(String[] args) {
        int maxSubArray = maxSubArray(nums);
        System.out.println("maxSubArray = " + maxSubArray);
    }
}
