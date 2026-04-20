package DynamicProgramming;

/**
 * @author Caius
 * @description Lc 1092 最短公共超序列
 *
 * @since Created in 2026-04-20
 */
public class Lc1092 {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) dp[i][0] = i;
        for (int j = 1; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = n, j = m;
        StringBuilder ans = new StringBuilder();
        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i][j] == dp[i - 1][j] + 1) {
                ans.append(str1.charAt(i - 1));
                i--;
            } else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }
        while(i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String ans = shortestCommonSupersequence("accabcba", "aacbbbbbaa");
        // ans aacbbbcabcbaa
        System.out.println("ans = " + ans);
    }
}
