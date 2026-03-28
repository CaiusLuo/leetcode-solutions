package graph;

/**
 * @author Caius
 * @description Lc 130 被围绕的区域
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 *
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果一个区域中的所有 'O' 单元格都不在棋盘的边缘，则该区域被包围。这样的区域 完全 被 'X' 单元格包围。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。
 *
 * @since Created in 2026/3/28
 */
public class Lc130 {
    // 测试用例
    private static char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
    };
    // 上下左右
    private static int[] x = new int[]{0, 0, -1, 1};
    private static int[] y = new int[]{1, -1, 0, 0};

    public static void solve(char[][] board) {
        // 左右
        for (int i = 0; i < board.length; i++) {
            dfs(board , i, 0);
            dfs(board, i, board[0].length - 1);
        }

        // 上下
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 1, i);
            dfs(board, board.length - 2, i);
        }

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;

        board[i][j] = '#';
        for(int k = 0; k < 4; ++k) {
            dfs(board, i + x[k], j + y[k]);
        }
    }

    public static void main(String[] args) {
        solve(board);

        for(char[] chars: board){
            for (char c: chars){
                System.out.print(c + " ");
            }
            System.out.println();
        }
//      --- ans ---
//        X X X X
//        X O O X
//        X X O X
//        X X X X
    }
}
