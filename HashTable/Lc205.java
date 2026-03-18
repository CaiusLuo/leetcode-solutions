package HashTable;

import java.util.HashMap;

/**
 * @author Caius
 * @description Lc 205 同构子符串
 *
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * @since Created in 2026-03-18
 */
public class Lc205 {

    private static String s = "egg";
    private static String t = "add";

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            if(s2t.containsKey(s.charAt(i)) && s2t.get(s.charAt(i)) != t.charAt(i) ||
                t2s.containsKey(t.charAt(i)) && t2s.get(t.charAt(i)) != s.charAt(i)) return false;

            s2t.put(s.charAt(i), t.charAt(i));
            t2s.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
