package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Caius
 * @description LCR 006 前 k 个高频元素
 *
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 *
 * @since Created in 2026-04-03
 */
public class LCR006 {
    private static int[] nums = {1,1,1,2,2,3};
    private static int k = 2;
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for(int key: map.keySet()){
            queue.offer(key);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] topKFrequent = topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent));
    }
}
