package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 54 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @since Created in 2026-03-17
 */
public class Lc54 {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0; int bottom = matrix.length - 1;
        int left = 0; int right = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while(top <= bottom && left <= right) {
//            左到右
            for(int i = left; i <= right; ++i){
                ans.add(matrix[top][i]);
            }
            top += 1;

//            上到下
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right-=1;

//            右到左
            if(top <= bottom) {
                for(int i = right; i  >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom-=1;
            }

//            下到上
            if(left <= right) {
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left += 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Lc54 solution = new Lc54();
        List<Integer> ans = solution.spiralOrder(solution.matrix);
        System.out.print("[");
        for(int i : ans) {
            System.out.print(i + " ,");
        }
        System.out.print("]");
    }
}
