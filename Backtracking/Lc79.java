package Backtracking;

/**
 * @author Caius
 * @description Lc79 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @since Created in 2026-04-01
 */
public class Lc79 {
    private static boolean[][] visited;
    private static char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    private static String word = "ABCCED";
    public static boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(backTracking(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean backTracking(char[][] board, int i, int j, int index, String word){
        if(index > word.length() - 1) return false;

        if(i < 0|| j < 0|| i >= board.length || j >= board[0].length) return false;

        if(visited[i][j]) return false;

        if(board[i][j] != word.charAt(index)) return false;

        if(index == word.length() - 1) return true;

        visited[i][j] = true;

        boolean found = backTracking(board, i + 1, j, index + 1, word) ||
                backTracking(board, i - 1, j, index + 1, word)||
                backTracking(board, i, j + 1, index + 1, word)||
                backTracking(board, i, j - 1, index + 1, word);

        visited[i][j] = false;

        return found;
    }
    public static void main(String[] args) {
        boolean exist = exist(board, word);
        System.out.println(exist);
    }
}
