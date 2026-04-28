package DynamicProgramming;

/**
 * @author Caius
 * @description Lc132 分割回文串 II
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的 最少分割次数 。
 *
 * @since Created in 2026/4/28
 */
public class Lc132 {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int left = 0; left <= n - len; left++) {
                int right = left + len - 1;
                if(s.charAt(left) == s.charAt(right)) {
                    // 子串的回文后面 扩展字符串才会回文
                    if(right - left <= 2 || isPal[left + 1][right - 1])
                        isPal[left][right] = true;
                }
            }
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // 最坏情况全部切一遍
            dp[i] = i;
            if(isPal[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if(isPal[j][i])
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        int ans = minCut("cabababcbc");
        System.out.println("ans = " + ans);
    }
}
