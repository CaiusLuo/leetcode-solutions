package HashTable;

import java.util.HashMap;

/**
 * @author Caius
 * @description Lc 383 赎金信
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * @since Created in 2026-03-09
 */
public class Lc383 {

    private String ransomNote = "a";
    private String magazine  = "b";

    /**
     * 使用 hashMap 实现判断是否存在
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return false;

            map.put(c, map.get(c) - 1);
        }

        return true;
    }
    public static void main(String[] args) {
        Lc383 solution = new Lc383();
        boolean ans = solution.canConstruct(solution.ransomNote, solution.magazine);
        System.out.println(ans);
    }
}
