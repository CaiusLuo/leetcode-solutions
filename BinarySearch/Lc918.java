package BinarySearch;

/**
 * @author Caius
 * @description Lc918 环形子数组的最大和
 *
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 * @since Created in 2026-04-03
 */
public class Lc918 {

    private static int[] nums = {3,-2,2,-3};
    public static int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], curMax = nums[0];
        int globalMin = nums[0], curMin = nums[0];
        int totalSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, curMax);

            curMin = Math.min(curMin + nums[i], curMin);
            globalMin = Math.min(curMin, globalMin);

            totalSum += nums[i];
        }

        return globalMax >= 0 ? Math.max(globalMax, totalSum - globalMin) : globalMax;
    }

    public static void main(String[] args) {
        int maxSubarraySumCircular = maxSubarraySumCircular(nums);
        System.out.println("maxSubarraySumCircular = " + maxSubarraySumCircular);
    }
}
