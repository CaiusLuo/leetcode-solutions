package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Caius
 * @description Lc120 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @since Created in 2026-04-06
 */
public class Lc120 {
    /**
     * 一维解法
     * @param triangle
     * @return
     */
//    public static int minimumTotal(List<List<Integer>> triangle){
//        int[] dp = new int[triangle.size() + 1];
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            for (int j = 0; j <= i; j++) {
//                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
//            }
//        }
//        return dp[0];
//    }

    /**
     * 二维解法
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < triangle.get(n - 1).size() ; i++) dp[n - 1][i] = triangle.get(n - 1).get(i);

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                // 使用下一行的数据对上一行数据进行回填 逻辑
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + cur.get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));

        int ans = minimumTotal(lists);
        System.out.println("ans = " + ans);
    }
}
