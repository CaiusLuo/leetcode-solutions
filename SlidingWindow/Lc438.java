package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Caius
 * @description Lc438 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * @since Created in 2026/5/7
 */
public class Lc438 {
    /**
     * 通过整个区域的区间数据进行移动窗口
     * @param s 判断字符串
     * @param p 比较 patten 子串
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        // 对比的子串长度大于目标串所以直接返回空
        if(sLen < pLen) return res;
        // 创建窗口字符数位数组
        int[] windows = new int[26];
        int[] target = new int[26];
        // 初始化
        for (int i = 0; i < pLen; i++) {
            windows[s.charAt(i) - 'a']++;
            target[p.charAt(i) - 'a']++;
        }
        // 比较第一次
        if(Arrays.equals(windows, target)) res.add(0);

        int left = 0;
        int right = pLen;
        while(right < sLen) {
            windows[s.charAt(left++) - 'a']--;
            windows[s.charAt(right++) - 'a']++;
            if(Arrays.equals(windows, target)) res.add(left);
        }
        return res;
    }

    public static void main(String[] args) {
        // 测试用例 1: s = "cbaebabacd", p = "abc"
        String s1 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> result1 = findAnagrams(s1, p1);
        System.out.println("测试用例 1: s = \"" + s1 + "\", p = \"" + p1 + "\" -> " + result1);

        // 测试用例 2: s = "abab", p = "ab"
        String s2 = "abab";
        String p2 = "ab";
        List<Integer> result2 = findAnagrams(s2, p2);
        System.out.println("测试用例 2: s = \"" + s2 + "\", p = \"" + p2 + "\" -> " + result2);

        // 测试用例 3: s = "aa", p = "aaa" (s 长度小于 p)
        String s3 = "aa";
        String p3 = "aaa";
        List<Integer> result3 = findAnagrams(s3, p3);
        System.out.println("测试用例 3: s = \"" + s3 + "\", p = \"" + p3 + "\" -> " + result3);

        // 测试用例 4: s = "abc", p = "def" (无匹配)
        String s4 = "abc";
        String p4 = "def";
        List<Integer> result4 = findAnagrams(s4, p4);
        System.out.println("测试用例 4: s = \"" + s4 + "\", p = \"" + p4 + "\" -> " + result4);
    }
}
