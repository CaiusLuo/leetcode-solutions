package DynamicProgramming;

/**
 * @author Caius
 * @description Lc97 交错字符串
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 *
 * @since Created in 2026-04-21
 */
public class Lc97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()) return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        // 初始化将第一列 放置
        for (int i = 1; i <= n; i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        // 初始化将第一行 放置
        for (int j = 1; j <= m; j++) dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 判断上面的 s1 字符是否想等
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) dp[i][j] |= dp[i - 1][j];
                // 判断左边的 s2 字符是否想等
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)) dp[i][j] |= dp[i][j - 1];
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        boolean interleave = isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println("interleave = " + interleave);
    }
}
