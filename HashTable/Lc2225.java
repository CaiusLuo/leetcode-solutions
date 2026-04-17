package HashTable;

import java.util.*;

/**
 * @author Caius
 * @description Lc 2225 找出输掉零场比赛的玩家
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * @since Created in 2026/4/16
 */
public class Lc2225 {

    private static int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9}};

    /**
     * 主要需要注意的实现问题是返回的数据是递增量
     * @param matches 比赛表
     * @return 找出输掉零场比赛的玩家
     */
    public static List<List<Integer>> findWinners(int[][] matches) {
        // 使用 treeMap 实现排序操作 或者直接 hashMap + Collecations.sort 实现排序返回
        Map<Integer, Integer> loseCount = new TreeMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            loseCount.put(winner, loseCount.getOrDefault(winner, 0));
            loseCount.put(loser, loseCount.getOrDefault(loser, 0) + 1);
        }
        List<Integer> noLossPlayers = new ArrayList<>();
        List<Integer> oneLossPlayers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : loseCount.entrySet()) {
            int player = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                noLossPlayers.add(player);
            } else if (count == 1) {
                oneLossPlayers.add(player);
            }
        }
        return Arrays.asList(noLossPlayers, oneLossPlayers);
    }

    public static void main(String[] args) {
        List<List<Integer>> winners = findWinners(matches);
        winners.forEach(list -> {
            System.out.println("list = " + list);
        });
    }
}
