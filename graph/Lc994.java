package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc 994 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * @since Created in 2026/4/16
 */
public class Lc994 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // ans == 4
//    private static int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    // ans == -1
    private static int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
    /**
     * 广度优先搜索实现
     * 1. 将所有腐烂的橘子加入队列
     * 2. 每次从队列中取出一个腐烂的橘子，腐烂其周围的4个方向上的新鲜橘子，并将新腐烂的橘子加入队列
     * 3. 记录腐烂的分钟数，直到队列为空
     * @param grid 橘子图
     * @return 需要花费的分钟数
     */
    public static int orangesRotting(int[][] grid) {
        int min = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        // bfs 实现时间记录最小值
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isRottingRound = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for(int[] d: DIRECTIONS) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = 2;
                        fresh--;
                        isRottingRound = true;
                    }
                }
            }
            if(isRottingRound) min++;
        }
        return fresh == 0 ? min : -1;
    }
    public static void main(String[] args) {
        int min = orangesRotting(grid);
        System.out.println("min = " + min);
    }
}
