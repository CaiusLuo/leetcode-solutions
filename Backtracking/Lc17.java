package Backtracking;

import java.util.Scanner;

/**
 * @author Caius
 * @description Lc 17 电话号码组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @since Created in 2026-03-13
 */
public class Lc17 {
//    public static String[] MAPPING = new String[]{"", "", "abc", "def", "hij", "lmn", ""};
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        int m = in.nextInt();
        in.nextLine();
        Long l = in.nextLong();

        System.out.println(n);
        System.out.println(m);
        System.out.println(l);
    }
}