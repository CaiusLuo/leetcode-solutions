package DoublePointer;

/**
 * @author Caius
 * @description Lc443 压缩字符串
 *
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 * 注意：数组中超出返回长度的字符无关紧要，应予忽略。
 *
 * @since Created in 2026/5/7
 */
public class Lc443 {
    private static int compress(char[] chars) {
        int read = 0;
        int write = 0;
        while(read < chars.length) {
            // 当前读取字符
            char currChar = chars[read];
            int count = 0;
            while(read < chars.length && chars[read] == currChar) {
                count++;
                read++;
            }
            // 写入当前字符
            chars[write++] = currChar;
            for(char ch: Integer.toString(count).toCharArray()) {
                chars[write++] = ch;
            }
        }
        return write;
    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int compress = compress(chars);
        System.out.println("compress = " + compress);
    }
}
