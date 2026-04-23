package DynamicProgramming;

/**
 * @author Caius
 * @description Lc516 最长回文子序列
 *
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * @since Created in 2026-04-23
 */
public class Lc516 {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            // 单个单词的回文的数量为 1
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                // 实际是将 左右两边的 字符全部加入
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                // 将最长的部分进行 传递
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
//        int ans = longestPalindromeSubseq("bbbab");
        int ans = longestPalindromeSubseq("cbbd");
        System.out.println("ans = " + ans);
    }
}
