package DoublePointer;

import java.util.*;

/**
 * @author Caius
 * @description Lc 392 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * @since Created in 2026-03-08
 */
public class Lc392 {
    /**
     * ans = true
     */
//    private  String s = "abc";
//    private  String t = "ahbgdc";

    /**
     * ans = false
     */
    private  String s = "axc";
    private  String t = "ahbgdc";

    /**
     * 判断 s 是否是 t 中间的子系列字符串 - 简单版本
     * 时间复杂度: O(|s| + |t|)
     * 空间复杂度: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t){
        int sPtr = 0;
        int tPtr = 0;

        while(sPtr < s.length() && tPtr < t.length()){
            if(s.charAt(sPtr) == t.charAt(tPtr)) sPtr++;

            tPtr++;
        }

        if(sPtr == s.length()) return true;

        return false;
    }

    /**
     * 判断 s 是否是 t 的子序列 - 进阶版本
     * 当有大量输入 S 需要检查是否为同一个 T 的子序列时使用
     * 通过预处理 T 字符串，构建字符位置索引，提高查找效率
     *
     * 对于 k 次查询的总时间复杂度: O(|T| + k * |S| * log|T|)
     * 而 k 次简单版本查询的时间复杂度是 O(k * (|S| + |T|))
     *
     * @param s 要检查的子序列
     * @param t 目标字符串
     * @return
     */
    public boolean proisSubsequence(String s, String t) {
        // 预处理: 为 T 中每个字符建立索引映射，记录每个字符出现的所有位置
        // map.get(c) 是一个有序列表，包含字符 c 在 T 中的所有出现位置
        Map<Character, List<Integer>> charMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, new ArrayList<>());
            }
            charMap.get(c).add(i);
        }

        // 检查 s 是否为 t 的子序列
        int prevIndex = -1; // 上一个匹配字符在 t 中的位置

        for (char c : s.toCharArray()) {
            // 如果字符 c 不在 t 中，则不可能是子序列
            if (!charMap.containsKey(c)) {
                return false;
            }

            // 在字符 c 的位置列表中，二分查找第一个大于 prevIndex 的位置
            List<Integer> posList = charMap.get(c);
            int pos = binarySearchFirstLarger(posList, prevIndex);

            // 如果没有找到合适的位置，则不是子序列
            if (pos == -1) {
                return false;
            }

            // 更新已匹配的位置
            prevIndex = pos;
        }

        return true;
    }

    /**
     * 在有序列表中二分查找第一个大于 target 的元素
     * @param list 有序列表
     * @param target 目标值
     * @return 找到的第一个大于 target 的元素值，如果不存在返回 -1
     */
    private int binarySearchFirstLarger(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                result = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Lc392 solution = new Lc392();
        boolean subsequence = solution.isSubsequence(solution.s, solution.t);
        System.out.println("简单版本结果: " + subsequence);

        boolean proSubsequence = solution.proisSubsequence(solution.s, solution.t);
        System.out.println("进阶版本结果: " + proSubsequence);

        // 测试大量查询的场景
        String[] testSArray = {"axc", "abc", "hdc", "xyz"};
        System.out.println("大量查询测试:");
        for (String testS : testSArray) {
            boolean result = solution.proisSubsequence(testS, solution.t);
            System.out.println("  s = \"" + testS + "\", isSubsequence = " + result);
        }
    }
}
