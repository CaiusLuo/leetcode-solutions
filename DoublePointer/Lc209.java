package DoublePointer;

/**
 * @author Caius
 * @description LC 209 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @since Created in 2026-03-10
 */
public class Lc209 {

    private int target = 7;
    private int[] nums = {2,3,1,2,4,3};

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            if(sum >= target) {
                ans = Math.min(ans, fast - slow + 1);
                sum -= nums[slow];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main(String[] args) {
        Lc209 solution = new Lc209();
        int ans = solution.minSubArrayLen(solution.target, solution.nums);
        System.out.println(ans);
    }
}
