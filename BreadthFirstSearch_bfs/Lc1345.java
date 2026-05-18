package BreadthFirstSearch_bfs;

import java.util.*;

/**
 * @author Caius
 * @description Lc1345 跳跃游戏 IV
 *
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 *
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 * @since Created in 2026/5/18
 */
public class Lc1345 {
    /**
     * bfs + map 存储初始数据
     * @param arr
     * @return
     */
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int steps = 0;
        boolean[] isPass = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(0);
        isPass[0] = true;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if(curr == n - 1) return steps;
                if(curr + 1 < n && !isPass[curr + 1]) {
                    queue.offer(curr + 1);
                    isPass[curr + 1] = true;
                }

                if(curr - 1 >= 0 && !isPass[curr - 1]) {
                    queue.offer(curr - 1);
                    isPass[curr - 1] = true;
                }

                if(map.containsKey(arr[curr])) {
                   for(int j : map.get(arr[curr])) {
                       if(!isPass[j]) {
                           queue.offer(j);
                           isPass[j] = true;
                       }
                   }
                   map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        int ans = minJumps(arr);
        System.out.println("ans = " + ans);
    }
}
