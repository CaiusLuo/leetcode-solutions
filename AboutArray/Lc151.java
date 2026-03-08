package AboutArray;

/**
 * @author Caius
 * @description Lc 151 反转字符串中间单词
 *
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * @since Created in 2026-03-08
 */
public class Lc151 {
    /**
     * ans = "blue is sky the"
     */
//    private String s = "the sky is blue";
    /**
     * ans = "world hello"
     */
//    private String s = "  hello world  ";
    /**
     * ans = "example good a"
     */
    private String s = "a good   example";

    /**
     * 实现反转字符串中间单词
     * 两轮反转
     * @param s
     * @return
     */
    public String reverseWords(String s){
        char[] str = s.toCharArray();
        int n = str.length;
        reverse(str, 0, n-1);

        int slow = 0;
        int fast = 0;

        while(fast < n){

            while(fast < n && str[fast] == ' ') fast++;

            if(fast >= n) break;

            if(slow > 0) str[slow++] = ' ';

            int start = slow;

            while(fast < n && str[fast] != ' ') str[slow++] = str[fast++];

            reverse(str, start, slow-1);
        }

        return new String(str, 0, slow);
    }

    /**
     * 反转函数
     */
    private void reverse(char[] str, int left, int right){
        while(left < right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Lc151 solution = new Lc151();
        String str = solution.reverseWords(solution.s);
        System.out.println("[" + str + "]");
    }
}
