package AboutArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description LC68 文本左右对齐
 *
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * @since Created in 2026-03-08
 */
public class Lc68 {

    /**
     * [
     *    "This    is    an",
     *    "example  of text",
     *    "justification.  "
     * ]
     */
    private String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    private int maxWidth = 16;

    /**
     * 匹配排序之后的字符串 List
     * @param word
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] word, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int index = 0;

        while(index < word.length) {
            int j = index;
            int len = 0;

            // 找第一排的元素
            while(j < word.length && len + word[j].length() + (j - index) <= maxWidth) {
                len += word[j].length();
                j++;
            }

            int gap = j - index - 1;
            int spaces = maxWidth - len;
            StringBuilder line = new StringBuilder();
            // 最后一行或者最后一个元素
            if(j == word.length || gap == 0){
                for(int k = index; k < j; ++k){
                    line.append(word[k]);
                    if(k < j - 1) line.append(" ");
                }
                while(line.length() < maxWidth) line.append(" ");
            } else {
                int avg = spaces / gap;
                int extra = spaces % gap;

                for(int k = index; k < j; ++k){
                    line.append(word[k]);
                    if(k < j - 1) {
                        int space = avg + (k - index < extra ? 1 : 0);
                        for(int s = 0; s < space; s++) {
                            line.append(" ");
                        }
                    }
                }
            }
            ans.add(line.toString());
            index = j;
        }
        return ans;
    }
    public static void main(String[] args) {
        Lc68 solution = new Lc68();
        List<String> ans = solution.fullJustify(solution.words, solution.maxWidth);
        for(String str : ans){
            System.out.println(str);
        }
    }
}
