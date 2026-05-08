package SlidingWindow;

/**
 * @author Caius
 * @description Lc206 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @since Created in 2026/5/7
 */
public class Lc206 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        while (right < n) {
            currSum += nums[right++];
            while(currSum >= target) {
                minLen = Math.min(minLen, right - left);
                currSum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1,4,4};
        int ans = minSubArrayLen(target, nums);
        System.out.println("ans = " + ans);
    }
}
