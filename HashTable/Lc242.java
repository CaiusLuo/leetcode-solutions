package HashTable;

import java.util.HashMap;

/**
 * @author Caius
 * @description Lc 242 有效的字母异位
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
 *
 * @since Created in 2026-03-18
 */
public class Lc242 {
    private static String s = "anagram";
    private static String t = "nagaram";

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                if (map.get(c) == 0) return false;

                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
}
