package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Caius
 * @description Lc 394 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 测试用例保证输出的长度不会超过 105。
 *
 * @since Created in 2026/5/7
 */
public class Lc394 {

    /**
     * 解码字符串：把形如 k[encoded_string] 的字符串展开。
     *
     * 核心思路：使用两个栈，一个存储重复次数，一个存储括号外的字符串。
     * 遍历字符串：
     * - 数字：累积次数。
     * - '['：压入次数和当前字符串，清空当前。
     * - ']'：弹出次数和前缀，重复拼接当前字符串到前缀。
     * - 字母：追加到当前字符串。
     */
    private static String decodeString(String s) {

        Deque<StringBuilder> strStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                Integer repeat = numStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < repeat; i++) prev.append(curr);
                curr = prev;
            } else curr.append(ch);
        }

        return curr.toString();
    }

    public static void main(String[] args) {
        // 示例：3[a]2[bc]
        // 过程简述：
        // 1. 遇到 3，num=3
        // 2. 遇到 [，numStack:[3], strStack:[""], curr清空
        // 3. 遇到 a，curr="a"
        // 4. 遇到 ]，repeat=3, prev="", 循环后 curr="aaa"
        // 5. 遇到 2，num=2
        // 6. 遇到 [，numStack:[2], strStack:["aaa"], curr清空
        // 7. 遇到 bc，curr="bc"
        // 8. 遇到 ]，repeat=2, prev="aaa", 循环后 curr="aaabcbc"
        String ans = decodeString("3[a]2[bc]");
        System.out.println("ans = " + ans);
    }
}
