package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Caius
 * @description Lc 51 N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @since Created in 2026/4/16
 */
public class Lc51 {
    private static boolean[] useCol;
    private static boolean[] useDiag1;
    private static boolean[] useDiag2;
    private static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        useCol = new boolean[n];
        useDiag1 = new boolean[2 * n];
        useDiag2 = new boolean[2 * n];
        char[][] grid = new char[n][n];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, '.'));
        backTracking(grid, 0, n);
        return res;
    }
    private static void backTracking(char[][] grid, int row, int n){
        if(row == n) {
            List<String> cur = new ArrayList<>();
            for(char[] g: grid) cur.add(new String(g));
            res.add(cur);
            return;
        }

        for(int col = 0; col < n; ++col) {
            if(useCol[col]) continue;
            int d1 = row - col + n;
            int d2 = row + col;
            if(!useDiag1[d1] && !useDiag2[d2]) {
                useCol[col] = useDiag1[d1] = useDiag2[d2] = true;
                grid[row][col] = 'Q';
                backTracking(grid, row + 1, n);
                grid[row][col] = '.';
                useCol[col] = useDiag1[d1] = useDiag2[d2] = false;
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        ans.forEach(row -> {
            row.forEach(System.out::println);
            System.out.println();
        });
    }
}
