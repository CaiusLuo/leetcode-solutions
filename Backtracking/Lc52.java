package Backtracking;

/**
 * @author Caius
 * @description Lc 52  N 皇后 II
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * @since Created in 2026-04-01
 */
public class Lc52 {
    private static char[][] board;
    private static int count;
    public static int totalNQueens(int n) {
        board = new char[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        backTracking(0, n);
        return count;
    }

    private static void backTracking(int row, int n) {
        if(row == n) {
            count++;
            return;
        }
        for(int col = 0; col < n; ++col) {
            if(isValidQ(row, col)) {
                board[row][col] = 'Q';
                backTracking(row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValidQ(int row, int col) {
        for(int i = row; i >= 0; --i) if(board[i][col] == 'Q') return false;
        for(int i = row, j = col; j >= 0 && i >= 0; i--, j--) if(board[i][j] == 'Q') return false;
        for(int i = row, j = col; j < board[0].length && i>= 0; j++, i--) if(board[i][j] == 'Q') return false;

        return true;
    }
    public static void main(String[] args) {
        int ans = totalNQueens(8);
        System.out.println(ans);
    }
}
