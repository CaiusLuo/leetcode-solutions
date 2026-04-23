package DoublePointer;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc 16 最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个在 不同下标位置 的整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * @since Created in 2026-04-23
 */
public class Lc16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int cur = nums[left] + nums[right] + nums[i];
                int curDiff = target - cur;
                if(curDiff == 0) return target;
                else if (curDiff > 0) {
                    // target > cur
                    left++;
                } else {
                    right--;
                }
                if(diff > Math.abs(curDiff)) {
                    diff = Math.abs(curDiff);
                    ans = cur;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int ans = threeSumClosest(nums, target);
        System.out.println("ans = " + ans);
    }
}
