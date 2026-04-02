package BinarySearch;

/**
 * @author Caius
 * @description Lc74 搜索二维矩阵
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * @since Created in 2026-04-03
 */
public class Lc74 {
    private static int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60},
    };
    private static int target = 3;
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; ++i) {
            if(matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                int left = 0;
                int  right = matrix[i].length - 1;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if(matrix[i][mid] == target) return true;
                    if(matrix[i][mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean searchMatrix = searchMatrix(matrix, target);
        System.out.println("searchMatrix = " + searchMatrix);
    }
}
