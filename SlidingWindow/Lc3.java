package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-09
 */
public class Lc3 {
    private String s = "pwwkew";

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc3 solution = new Lc3();
        int ans = solution.lengthOfLongestSubstring(solution.s);
        System.out.println(ans);
    }
}
