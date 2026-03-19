package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Caius
 * @description LC 20 有效的括号
 * @since Created in 2026-03-19
 */
public class Lc20 {
    private static String s = "()[]{}";

    /**
     * 栈 -- 实现
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        Deque<Character> deque = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if(!map.containsKey(c)) {
                deque.push(c);
            } else if(deque.isEmpty() || deque.pop() != map.get(c)) {
                return false;
            }
        }
        return deque.isEmpty();
    }
    public static void main(String[] args) {
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
