package HashTable;

/**
 * @author Caius
 * @description Lc73 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @since Created in 2026-03-17
 */
public class Lc73 {
//    int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

    int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    public void setZeros(int[][] matrix) {
        int row = matrix.length;
        int clo = matrix[0].length;

        boolean firstRow = false;
        boolean firstClo = false;

        for(int i = 0; i < row; ++i) {
            if(matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }

        for(int j = 0; j < clo; ++j) {
            if(matrix[0][j] == 0) {
                firstClo = true;
                break;
            }
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < clo; ++j){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < clo; ++j) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(firstRow) for(int i = 0; i < clo; i++) matrix[0][i] = 0;
        if(firstClo) for(int j = 0; j < row; ++j) matrix[j][0] = 0;
    }
    public static void main(String[] args) {
        Lc73 solution = new Lc73();
        solution.setZeros(solution.matrix);

        for (int[] ans : solution.matrix){
            System.out.print("[");
            for(int i : ans) {
                System.out.print(i + " ,");
            }
            System.out.print("]");
        }
    }
}
