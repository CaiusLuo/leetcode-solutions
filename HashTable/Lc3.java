package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Caius
 * @description LC 3 无重复字符的最小字串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * @since Created in 2026-03-10
 */
public class Lc3 {
    /**
     * ans = 3
     */
    private String s = "abcabcbb";

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int slow = 0;
        int fast = 0;

        while(fast < s.length()) {
            if(map.containsKey(s.charAt(fast))) {
                while(map.containsKey(s.charAt(fast))) {
                    map.remove(s.charAt(slow++));
                }
            }

            map.put(s.charAt(fast), fast);
            ans = Math.max(ans, fast - slow + 1);
            fast++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Lc3 solution = new Lc3();
        int ans = solution.lengthOfLongestSubstring(solution.s);
        System.out.println(ans);
    }
}
