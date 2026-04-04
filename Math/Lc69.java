package Math;

/**
 * @author Caius
 * @description Lc69  x 的平方根
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @since Created in 2026-04-04
 */
public class Lc69 {
    public static int mySqrt(int x) {
        if(x < 2) return x;
        int left = 0;
        int right = x;
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = mySqrt(8);
        System.out.println("ans = " + ans);
    }
}
