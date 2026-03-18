package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-18
 */
public class Lc290 {

    private static String pattern = "abba";
    private static String s = "dog cat cat dog";

    public static boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length) return false;

        Map<Character ,String> c2s = new HashMap<>();
        Map<String ,Character> s2c = new HashMap<>();

        for(int i = 0; i < str.length; ++i) {
            if(c2s.containsKey(pattern.charAt(i)) && !c2s.get(pattern.charAt(i)).equals(str[i]) ||
            s2c.containsKey(str[i]) && s2c.get(str[i]) != pattern.charAt(i)) return false;

            c2s.put(pattern.charAt(i), str[i]);
            s2c.put(str[i], pattern.charAt(i));
        }

        return true;
    }
    public static void main(String[] args) {
        boolean wordPattern = wordPattern(pattern, s);
        System.out.println(wordPattern);
    }
}
