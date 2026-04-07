package SlidingWindow;

import java.util.*;

/**
 * @author Caius
 * @description
 * @since Created in 2026/4/7
 */
public class Lc239 {
    /**
     * 1. 双端队列
     * 2. 判断前面小于数值
     * 3. 加入数字【方便后续判断】
     * 4. 后续数字是否 过期 -- out of k range
     * 5. 判断是否加入 res
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // metion !!! 前面所有元素全部删除
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();

            deque.offerLast(i);

            if(deque.peekFirst() < i - k + 1) deque.pollFirst();

            if(i >= k - 1) res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
