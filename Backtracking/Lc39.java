package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 39 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * @since Created in 2026-04-01
 */
public class Lc39 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static int[] candidates = {2,3,6,7};
    private static int target = 7;
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        dfs(candidates, 0, 0, target);
        return res;
    }

    private static void dfs(int[] candidates, int sum, int startIndex, int target) {
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, sum + candidates[i], i, target);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.print("[");
        lists.forEach(System.out::print);
        System.out.print("]");
    }
}
