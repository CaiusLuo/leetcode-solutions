package InterviewQuestions;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author Caius
 * @description LCR 050. 路径总和 III
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @since Created in 2026-03-12
 */
public class LCR050 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k) {
                queue.offer(nums[i]);
            } else if(queue.peek() < nums[i]) {
                queue.offer(nums[i]);
                queue.poll();
            }
        }

        return queue.peek();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};

        int k = 2;

        int ans = new LCR050().findKthLargest(nums, k);

        System.out.println(ans);
    }
}
