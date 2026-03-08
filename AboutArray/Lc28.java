package AboutArray;

/**
 * @author Caius
 * @description Lc28 字符串第一个匹配项的下标
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * @since Created in 2026-03-08
 */
public class Lc28 {

    /**
     * ans = 0
     */
//    private String haystack = "sadbutsad";
//    private String needle  = "sad";

    /**
     * ans = -1
     */
    private String haystack = "leetcode";
    private String needle  = "leeto";

    /**
     * 字符串匹配第一个下标
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while(j < m && haystack.charAt(i + j) == needle.charAt(j)) j++;

            if(j == m) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        Lc28 solution = new Lc28();
        int ans = solution.strStr(solution.haystack, solution.needle);
        System.out.println(ans);
    }
}
