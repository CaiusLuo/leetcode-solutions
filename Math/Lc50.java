package Math;

/**
 * @author Caius
 * @description Lc50 Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 * @since Created in 2026-04-04
 */
public class Lc50 {
    private static double x = 2.00000;
    private static int n = 10;
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 1) return x;
        long b = n;
        int ans = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                ans *= x;
            }
            x *= x;
            b>>=1;
        }
        return ans;
    }
    public static void main(String[] args) {
        double myPow = myPow(x, n);
        System.out.println("myPow = " + myPow);
    }
}
