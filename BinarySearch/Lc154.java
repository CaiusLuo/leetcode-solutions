package BinarySearch;

/**
 * @author Caius
 * @description Lc154 寻找旋转排序数组中的最小值 II
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后
 * 得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次
 * 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组
 * 并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须尽可能减少整个过程的操作步骤。
 *
 * @since Created in 2026/5/13
 */
public class Lc154 {
    /**
     * 思路：二分查找，比较 mid 与 right。
     * - 若 nums[mid] < nums[right]，最小值在 [left, mid]。
     * - 若 nums[mid] > nums[right]，最小值在 [mid + 1, right]。
     * - 若相等，无法判断，缩小 right。
     * 时间：平均 O(log n)，最坏 O(n)；空间：O(1)。
     */
    public static int findMin(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[right] > nums[mid]) {
                right = mid;
            } else if(nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[right];
    }
    public static void main(String[] args) {
//        int[] nums = {3, 1, 3};
//        int[] nums = {1};
        int[] nums = {2,2,2,0,1};
        int min = findMin(nums);
        System.out.println("min = " + min);
    }
}
