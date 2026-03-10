package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Caius
 * @description LC 15 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @since Created in 2026-03-10
 */
public class Lc15 {
    /**
     * ans = [[-1,-1,2],[-1,0,1]]
     */
    private int[] nums = {-1,0,1,2,-1,-4};

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            while(left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;

                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (tmp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Lc15 solution = new Lc15();
        List<List<Integer>> ans = solution.threeSum(solution.nums);

        for(List<Integer> a : ans) {
            System.out.print("[");
            for(int i : a) System.out.print(i + ",");
            System.out.print("]");
        }
    }
}
