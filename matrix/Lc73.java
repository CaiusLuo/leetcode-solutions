package matrix;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc 73 矩阵置零
 * @since Created in 2026-03-18
 */
public class Lc73 {

//    private int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

    private int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstClo = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstClo = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow) for(int j = 0; j < matrix[0].length; ++j) matrix[0][j] = 0;
        if(firstClo) for(int i = 0; i < matrix.length; ++i) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        Lc73 solution = new Lc73();
        solution.setZeroes(solution.matrix);

        for(int[] ans: solution.matrix) {
            System.out.println(Arrays.toString(ans));
        }
    }
}
