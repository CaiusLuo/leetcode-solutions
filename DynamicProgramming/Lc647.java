package DynamicProgramming;

/**
 * @author Caius
 * @description Lc647 回文子串
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * @since Created in 2026-04-23
 */
public class Lc647 {
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int len = 1; len <= n; len++) {
            // 构建长度中间对应的边界中间[i, j] 实现对应的边界逻辑
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if(s.charAt(j) == s.charAt(i)) {
                    if(len < 3 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int ans = countSubstrings("abc");
//        int ans = countSubstrings("aaa");
        System.out.println("ans = " + ans);
    }
}
