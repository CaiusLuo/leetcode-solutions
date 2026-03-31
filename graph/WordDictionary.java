package graph;

/**
 * @author Caius
 * @description Lc 211 添加与搜索单词 - 数据结构设计
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * @since Created in 2026-03-31
 */
public class WordDictionary {
    WordDictionary[] son;
    boolean isEnd;

    public WordDictionary() {
        son = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(node.son[index] == null) node.son[index] = new WordDictionary();
            node = node.son[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String word, int index, WordDictionary node) {
        if(index == word.length()) return node.isEnd;
        char c = word.charAt(index);
        if(c != '.'){
            int cIndex = c - 'a';
            return node.son[cIndex] != null && dfs(word, index + 1, node.son[cIndex]);
        } else {
            for (int i = 0; i < 26; i++) {
                if(node.son[i] != null && dfs(word, index + 1, node.son[i])) return true;
            }
            return false;
        }
    }
}
