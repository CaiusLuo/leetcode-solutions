package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc212 单词搜索 II
 *
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * @since Created in 2026-03-31
 */
public class Lc212 {
     static class TairNode{
        TairNode[] next = new TairNode[26];
        String word;
    }

    private static char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };

    private static String[] words = {"oath","pea","eat","rain"};

    /**
     * 题解 1. 构建无向图 2. dfs 遍历
     * 注意 ⚠️  不需要求最小值 --- 直接 dfs 遍历️
     * @param board
     * @param words
     * @return
     */
    public static List<String> findWords(char[][] board, String[] words) {
        TairNode root = buildTair(words);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    /**
     * 深度优先遍历
     * @param board
     * @param i
     * @param j
     * @param node
     * @param res
     */
    private static void dfs(char[][] board, int i, int j, TairNode node, List<String> res) {
        char c = board[i][j];
        if(c == '#') return;

        int index = c - 'a';
        TairNode child = node.next[index];
        if(child == null) return;
        // 添加同时置空避免 重复添加
        if(child.word != null) {
            res.add(child.word);
            child.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, child, res);
        if (j > 0) dfs(board, i, j - 1, child, res);
        if (i < board.length - 1) dfs(board, i + 1, j, child, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, child, res);
        board[i][j] = c;
    }
    /**
     * 构建无向图
     * @param words
     * @return
     */
    private static TairNode buildTair(String[] words) {
        TairNode root = new TairNode();
        for(String w : words){
            TairNode p = root;
            for(char c : w.toCharArray()) {
                int index = c - 'a';
                if(p.next[index] == null) p.next[index] = new TairNode();
                p = p.next[index];
            }
            p.word = w;
        }
        return root;
    }
    public static void main(String[] args) {
        List<String> list = findWords(board, words);
        list.stream().forEach(s -> System.out.println(s));
    }
}
