package DynamicProgramming;

/**
 * @author Caius
 * @description Lc 115 不同的子序列
 *
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
 *
 * 测试用例保证结果在 32 位有符号整数范围内。
 *
 * @since Created in 2026-04-21
 */
public class Lc115 {
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        long[][] dp = new long[n + 1][m + 1];
        // t 是空串所以全部都是匹配一个模式 | 全部删除
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 使用 | 不使用 的叠加
                if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                // 不使用 跳过当前的叠加
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return (int)dp[n][m];
    }
    public static void main(String[] args) {
        int ans = numDistinct("babgbag", "bag");
        System.out.println("ans = " + ans);
    }
}
