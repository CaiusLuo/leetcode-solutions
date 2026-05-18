package BinarySearch;

/**
 * @author Caius
 * @description Lc81 搜索旋转排序数组 II
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 你必须尽可能减少整个操作步骤。
 *
 * @since Created in 2026/5/13
 */
public class Lc81 {
    /**
     * 思路：二分查找 + 处理重复元素。
     * 每次比较 mid 与 left/right 的关系：
     * - 若 nums[left] == nums[mid] 且 nums[mid] == nums[right]，无法判断有序段，收缩边界。
     * - 若 nums[left] == nums[mid] 但 nums[mid] != nums[right]，左边重复导致无法判断，左指针右移。
     * - 否则判断哪一段有序，再决定缩小哪一侧。
     * 时间：平均 O(log n)，最坏 O(n)；空间：O(1)。
     * @param nums
     * @param target
     * @return
     */
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            // 如果相同就直接缩小范围，因为相同的数据中间不需要移动数据
            if(nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if(nums[mid] >= nums[left]) {
                if(nums[left] <= target && target <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if(nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        boolean search = search(nums, target);
        System.out.println("search = " + search);
    }
}
