package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc22 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @since Created in 2026-04-01
 */
public class Lc22 {
    private static List<String> res;
    private static StringBuilder path;
    public static List<String> generateParenthesis(int  n) {
        res = new ArrayList<>();
        path = new StringBuilder();
        backTracking(n , 0, 0, path);
        return res;
    }

    private static void backTracking(int n, int left, int right, StringBuilder path) {
        if(left + right == n * 2) {
            res.add(path.toString());
            return;
        }

        if(left < n) {
            path.append('(');
            backTracking(n, left + 1, right, path);
            path.deleteCharAt(path.length() - 1);
        }

        if(right < left) {
            path.append(')');
            backTracking(n, left, right + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
