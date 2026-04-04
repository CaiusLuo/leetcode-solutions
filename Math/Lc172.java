package Math;

/**
 * @author Caius
 * @description Lc 172 阶乘后的零
 *
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 * @since Created in 2026-04-04
 */
public class Lc172 {
    /**
     * 尾随零的个数 = 因子 5 的个数
     * @param num 参数
     * @return 后缀 0 数量
     */
    public static int trailingZeroes(int num) {
        int ans = 0;
        while(num > 0) {
            ans += num/5;
            num /= 5;
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans = trailingZeroes(35);
        System.out.println("ans = " + ans);
    }
}
