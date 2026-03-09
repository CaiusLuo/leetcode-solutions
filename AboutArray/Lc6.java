package AboutArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description LC6 Z字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * @since Created in 2026-03-08
 */
public class Lc6 {
    /**
     * ans = PAHNAPLSIIGYIR
     */
    private String s = "PAYPALISHIRING";
    private int numRows = 3;

    /**
     * ans = PINALSIGYAHRPI
     */
//    private String s = "PAYPALISHIRING";
//    private int numRows = 4;
    /**
     * ans = A
     */
//    private String s = "A";
//    private int numRows = 1;

    /**
     * 实现 Z 字型变换【模拟实现】
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int row = 0;
        int diracation = 1;
        for(char c : s.toCharArray()) {
//            添加元素到数组中间
            rows.get(row).append(c);
//            定移动方向
            if(row == 0) diracation = 1;
            if(row == numRows - 1) diracation = -1;
            row += diracation;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb : rows) {
            ans.append(sb);
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        Lc6 solution = new Lc6();
        String ans = solution.convert(solution.s, solution.numRows);
        System.out.println(ans);
    }
}
