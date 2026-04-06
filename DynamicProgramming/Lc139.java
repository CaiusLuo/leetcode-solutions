package DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Caius
 * @description Lc139 单词拆分
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @since Created in 2026-04-05
 */
public class Lc139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        // 第一次遍历长度 -- equals(s.length())
        for (int i = 1; i <= s.length(); i++) {
            // 后序 字符串链接
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");
        boolean wordBreak = wordBreak(s, wordDict);

        System.out.println("wordBreak = " + wordBreak);
    }
}
