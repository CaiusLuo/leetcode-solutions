package matrix;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc 289 生命游戏
 *
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是 同时 发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * 给定当前 board 的状态，更新 board 到下一个状态。
 *
 * 注意 你不需要返回任何东西。
 *
 * @since Created in 2026-03-18
 */
public class Lc289 {

    private int[][] matrix = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

    public void gameOfLife(int[][] matrix) {
        int[] x = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; ++j) {
                int live = 0;
                for(int k = 0; k < 8; k++) {
                    int curX = i + x[k];
                    int curY = j + y[k];

                    if(curX < 0 || curX >= matrix.length || curY < 0 || curY >= matrix[0].length) continue;

                    if(matrix[curX][curY] == 1 || matrix[curX][curY] == 2) live++;
                }

                if(matrix[i][j] == 0){
                    if(live == 3) {
                        matrix[i][j] = -1;
                    }
                } else if(matrix[i][j] == 1) {
                    if(live > 3 || live < 2) {
                        matrix[i][j] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 1;
                } else if(matrix[i][j] == 2) {
                    matrix[i][j] =0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Lc289 solution = new Lc289();

        solution.gameOfLife(solution.matrix);

        for(int[] ans: solution.matrix) {
            System.out.println(Arrays.toString(ans));
        }
    }
}
