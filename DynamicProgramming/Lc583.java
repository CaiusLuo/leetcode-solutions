package DynamicProgramming;

/**
 * @author Caius
 * @description Lc 583 两个字符串的删除操作
 *
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * @since Created in 2026-04-20
 */
public class Lc583 {
    /**
     * 和 题目 Lc72 区别是不能替换操作
     * @param word1 字符串 1
     * @param word2 字符串 2
     * @return 最少操作
     */
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) dp[i][0] = i;
        for (int j = 1; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    // 只能进行删除操作 不能替换
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int ans = minDistance("leetcode", "etco");
        System.out.println("ans = " + ans);
    }
}
