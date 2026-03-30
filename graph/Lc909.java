package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc909 蛇形
 * @since Created in 2026-03-30
 */
public class Lc909 {
    // ans = 4
    public static int[][] board = {
            {-1,-1,-1,-1,-1,-1}
            ,{-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
    };
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        int[] path = new int[target + 1];
        int idx = 1;
        boolean leftToRight = true;
        for(int r = n - 1; r >= 0; r--) {
            if(leftToRight) {
                for(int l = 0; l < n; l++) {
                    path[idx++] = board[r][l];
                }
            } else {
                for(int l = n - 1; l >= 0; --l) {
                    path[idx++] = board[r][l];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[target + 1];
        visited[1] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                int cur = queue.poll();
                if(cur == target) return count;
                for(int k = 1; k <= 6; ++k) {
                    int next = cur + k;
                    if(next > target) break;
                    int destination = path[next] == -1 ? next : path[next];

                    if(visited[destination] == false) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            count++;
        }
        return  -1;
    }
    public static void main(String[] args) {
        int ans = snakesAndLadders(board);
        System.out.println(ans);
    }
}
