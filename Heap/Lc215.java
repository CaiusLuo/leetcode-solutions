package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc215 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @since Created in 2026-04-03
 */
public class Lc215 {
    private static int[] nums = {3,2,3,1,2,4,5,5,6};

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num: nums) {
            queue.offer(num);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int kthLargest = findKthLargest(nums, 4);
        System.out.println("kthLargest = " + kthLargest);
    }
}
