package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Caius
 * @description Lc373 查找和最小的 K 对数字
 *
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 * @since Created in 2026-04-03
 */
public class Lc373 {
    private static int[] nums1 = {1,7,11};
    private static int[] nums2 = {2,4,6};
    /**
     * 通过先纵向遍历 -- 横向比较获取最小堆实现返回
     * @param nums1
     * @param nums2
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{i, 0});
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        while(k-- > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            res.add(List.of(nums1[cur[0]], nums2[cur[1]]));
            if(cur[1] + 1 < nums2.length) {
                queue.add(new int[]{cur[0], cur[1] + 1});
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = kSmallestPairs(nums1, nums2, 3);
        ans.forEach(System.out::print);
    }
}
