package HashTable;

/**
 * @author Caius
 * @description Lc 48 旋转图像
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @since Created in 2026-03-17
 */
public class Lc48 {
    private int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    public void rotate(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix[0].length; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= tmp;
            }
        }

        for(int i = 0; i < matrix.length; ++i) {
            int left = 0;
            int right = matrix.length - 1;

            while(left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        Lc48 solution = new Lc48();
        solution.rotate(solution.matrix);
        for(int[] ans: solution.matrix) {
            System.out.print("[");
            for (int a: ans){
                System.out.print(a + " ,");
            }
            System.out.print("]");
        }
    }
}
