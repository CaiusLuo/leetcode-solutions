package DoublePointer;

/**
 * @author Caius
 * @description Lc 167 两数之和 II 输入有序数组
 *
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * @since Created in 2026-03-10
 */
public class Lc167 {
    private int[] numbers = {2,7,11,15};
    private int target = 9;

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int cur = numbers[left] + numbers[right];
            if(cur == target) {
                return new int[]{left + 1, right + 1};
            } else if(cur < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        Lc167 solution = new Lc167();
        int[] ans = solution.twoSum(solution.numbers, solution.target);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}
