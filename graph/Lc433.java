package graph;

import java.util.*;

/**
 * @author Caius
 * @description Lc 433 最小基因变化
 *
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 * @since Created in 2026-03-31
 */
public class Lc433 {

    private static String startGene = "AAAAACCC";
    private static String endGene = "AACCCCCC";
    private static  String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};

    private static char[] chars = {'A', 'C', 'G', 'T'};

    /**
     *  BFS
     *  1. 回退状态
     *  2. 结束步长判断
     *
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    public static int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < bank.length; ++i) {
            map.put(bank[i], false);
        }
        if(!map.containsKey(endGene)) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        map.put(startGene, true);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                String cur = queue.poll();
                char[] curChar = cur.toCharArray();
                for(int j = 0; j < curChar.length; ++j) {
                    char oldChar = curChar[j];
                    for(int k = 0; k < chars.length; ++k) {
                        if(chars[k] == oldChar) continue;
                        curChar[j] = chars[k];
                        String changeStr = new String(curChar);
                        if(map.containsKey(changeStr)) {
                            if(changeStr.equals(endGene)) return step + 1;
                            if(!map.get(changeStr)) {
                                map.put(changeStr, true);
                                queue.offer(changeStr);
                            }
                        }
                    }
                    curChar[j] = oldChar;
                }
            }
            step++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int ans = minMutation(startGene, endGene, bank);
        System.out.println(ans);
    }
}
