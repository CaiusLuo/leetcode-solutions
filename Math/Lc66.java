package Math;

import java.util.Arrays;

/**
 * @author Caius
 * @description lc66 加一
 *
 * 给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
 *
 * 将大整数加 1，并返回结果的数字数组。
 *
 * @since Created in 2026-04-04
 */
public class Lc66 {
    private static int[] digits = {4,3,2,1};

    /**
     * 单纯计数加一所以不需要复杂操作
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; ++i) {
            digits[i] ++;
            if(digits[i] < 10) return digits;
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
    public static void main(String[] args) {
        int[] ans = plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }
}
