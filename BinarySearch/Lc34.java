package BinarySearch;

import java.util.Arrays;

/**
 * @author Caius
 * @description
 * @since Created in 2026-04-03
 */
public class Lc34 {
    private static int[] nums = {5,7,7,8,8,10};
    private static int target = 8;
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                int start = mid, end = mid;
                while(start >= 0 && nums[start] == target) {
                    start--;
                }
                while(end < nums.length && nums[end] == target) {
                    end++;
                }
                return new int[]{start + 1, end - 1};
            }
            if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] ints = searchRange(nums, target);
        System.out.print("[");
        for(int num : ints) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
