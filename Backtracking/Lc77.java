package Backtracking;

import java.util.*;

/**
 * @author Caius
 * @description Lc77 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * @since Created in 2026-04-01
 */
public class Lc77 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    /**
     * 递归逻辑
     * @param n
     * @param k
     * @param startIndex
     */
    private static void dfs(int n, int k, int startIndex) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 闭区间
        for(int i = startIndex; i <= n; ++i) {
            path.add(i);
            dfs(n, k, i + 1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        combine.stream().forEach(System.out::println);
    }
}
