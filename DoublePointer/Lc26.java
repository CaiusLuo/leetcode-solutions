package DoublePointer;

/**
 * @author Caius
 * @description Lc 26 删除有序数组中的重复项
 *
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k。去重后，返回唯一元素的数量 k。
 *
 * nums 的前 k 个元素应包含 排序后 的唯一数字。下标 k - 1 之后的剩余元素可以忽略。
 *
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 * @since Created in 2026/5/7
 */
public class Lc26 {
    /**
     * 算法简洁解析：使用双指针，快指针遍历数组，慢指针记录唯一元素位置。
     * 当快指针遇到新元素时，更新慢指针位置并赋值。
     */
    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int slow = 0, fast = 0;
        while(fast < n) {
            int currNum = nums[fast];
            while(fast < n && nums[fast] == currNum) fast++;
            nums[slow++] = currNum;
        }
        return slow;
    }

    public static void main(String[] args) {
        // 测试用例 1: [1,1,2]
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.println("测试用例 1: k = " + k1 + ", nums = " + java.util.Arrays.toString(nums1));

        // 测试用例 2: [0,0,1,1,1,2,2,3,3,4]
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        System.out.println("测试用例 2: k = " + k2 + ", nums = " + java.util.Arrays.toString(nums2));

        // 测试用例 3: 空数组
        int[] nums3 = {};
        int k3 = removeDuplicates(nums3);
        System.out.println("测试用例 3: k = " + k3 + ", nums = " + java.util.Arrays.toString(nums3));

        // 测试用例 4: 单个元素
        int[] nums4 = {1};
        int k4 = removeDuplicates(nums4);
        System.out.println("测试用例 4: k = " + k4 + ", nums = " + java.util.Arrays.toString(nums4));
    }
}
