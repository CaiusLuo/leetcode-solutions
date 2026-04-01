package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 46 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @since Created in 2026-04-01
 */
public class Lc46 {
    private static int[] nums = {1,2,3};
    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();

    private static boolean[] used;
    public static List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }
    private static void dfs(int[] nums) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums);
            used[i] = false;
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = permute(nums);
        ans.forEach(System.out::println);
    }
}
