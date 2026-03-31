package graph;

import java.util.*;

/**
 * @author Caius
 * @description Lc127 单词接龙
 *
 * 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 * @since Created in 2026-03-31
 */
public class Lc127 {
    private static String beginWord = "hit";
    private static String endWord = "cog";
//    private static String[] wordList = {"hot","dot","dog","lot","log","cog"};
    private static String[] wordList = {"hot","dot","dog","lot","log"};

    public static int ladderLength(String beginWord, String endWord, String[] wordList) {
        Set<String> set = new HashSet<>(List.of(wordList));
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        int step = 1;
        queue.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                String cur = queue.poll();
                char[] curChar = cur.toCharArray();
                for(int j = 0; j < curChar.length; ++j) {
                    char oldChar = curChar[j];
                    for(char k = 'a'; k <= 'z'; ++k){
                        if(k == oldChar) continue;
                        curChar[j] = k;
                        String changeStr = new String(curChar);
                        if(!set.contains(changeStr)) continue;
                        if(changeStr.equals(endWord)) return step + 1;
                        set.remove(changeStr);
                        queue.offer(changeStr);
                    }
                    curChar[j] = oldChar;
                }
            }
            step++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int ans = ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);
    }
}
