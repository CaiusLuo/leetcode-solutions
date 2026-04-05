package Math;

/**
 * @author Caius
 * @description Lc201 数字范围按位与
 *
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 * @since Created in 2026-04-05
 */
public class Lc201 {

//    /**
//     * 通过移动 right 实现最长前缀和
//     * @param left
//     * @param right
//     * @return
//     */
//    public static int rangeBitwiseAnd(int left, int right) {
//        while(left < right) {
//            right &= (right - 1);
//        }
//        return right;
//    }
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left <<= shift;
    }
    public static void main(String[] args) {
        int ans = rangeBitwiseAnd(5, 7);
        System.out.println("ans = " + ans);
    }
}
