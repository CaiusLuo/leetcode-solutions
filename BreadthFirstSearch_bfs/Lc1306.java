package BreadthFirstSearch_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc1306 跳跃游戏 III
 *
 * 给定一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时
 * 你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 * @since Created in 2026/5/18
 */
public class Lc1306 {
    public static boolean canSearch(int[] arr, int start){
        int n = arr.length;
        boolean[] isPass = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        isPass[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(arr[curr] == 0) return true;
            int left = curr - arr[curr];
            int right = curr + arr[curr];
            if(left >= 0 && !isPass[left]) {
                queue.offer(left);
                isPass[left] = true;
            }
            if(right < n && !isPass[right]) {
                queue.offer(right);
                isPass[right] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        boolean canSearch = canSearch(arr, start);
        System.out.println("canSearch = " + canSearch);
    }
}
