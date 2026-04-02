package BinarySearch;

/**
 * @author Caius
 * @description Lc162 寻找峰值
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * @since Created in 2026-04-02
 */
public class Lc162 {
    private static int[] nums = {1,2,1,3,5,6,4};
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int peakElement = findPeakElement(nums);
        System.out.println("peakElement = " + peakElement);
    }
}
