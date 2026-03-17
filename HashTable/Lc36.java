package HashTable;

/**
 * @author Caius
 * @description Lc 36 有效的数独
 *
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * @since Created in 2026-03-17
 */
public class Lc36 {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    public boolean isValidSudoKu(char[][] board){
        boolean[][] row  = new boolean[9][9];
        boolean[][] clo = new boolean[9][9];
        boolean[][][] charHas = new boolean[3][3][9];

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                char tmp = board[i][j];
                if(tmp == '.') continue;
                // 转换坐标位置
                int x = board[i][j] - '1';
                if(row[i][x] || clo[j][x] || charHas[i / 3][j / 3][x]) return false;
                row[i][x] = clo[j][x] = charHas[i / 3][j / 3][x] = true;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Lc36 solution = new Lc36();
        boolean validSudoKu = solution.isValidSudoKu(solution.board);
        System.out.println(validSudoKu);
    }
}
