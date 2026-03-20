package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Caius
 * @description Lc 49 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * @since Created in 2026-03-18
 */
public class Lc49 {

    private static String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(strs);

        for(List<String> ans : lists) {
            System.out.print("[ ");
            for(String s : ans) {
                System.out.print(s + ",");
            }

            System.out.println(" ]");
        }
    }
}
