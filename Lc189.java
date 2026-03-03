/**
 * @author Caius
 * @description leetcode 189 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @since Created in 2026-03-04
 */
public class Lc189 {
    private static int[] nums = new int[]{1,2,3,4,5,6,7};

    /**
     * 实现轮转逻辑
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Lc189 solution = new Lc189();
        for(int num: solution.nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        solution.rotate(solution.nums, 3);
        for(int num: solution.nums) {
            System.out.print(num+" ");
        }
    }
}