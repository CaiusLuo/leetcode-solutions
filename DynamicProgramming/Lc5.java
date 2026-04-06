package DynamicProgramming;

/**
 * @author Caius
 * @description Lc5 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 * @since Created in 2026-04-06
 */
public class Lc5 {
    /**
     * 中间向外推广法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int maxStart = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && s.charAt(i) == s.charAt(left)) left--;
            while(right < s.length() && s.charAt(i) == s.charAt(right)) right++;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // 变换之后长度是对应长度减一
            int len = right - left - 1;
            if(maxLen < len) {
                maxLen = len;
                maxStart = left + 1;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        String ans = longestPalindrome(s);
        System.out.println("ans = " + ans);
    }
}
