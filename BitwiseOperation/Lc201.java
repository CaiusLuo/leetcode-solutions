package BitwiseOperation;

/**
 * @author Caius
 * @description Lc201 数字范围按位与
 *
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 * @since Created in 2026-04-04
 */
public class Lc201 {
    private static int left = 5;
    private static int right = 7;
//    逻辑 -- right 向左边移动实现最小前缀和
//    public static int rangeBitwiseAnd(int left , int right) {
//        while(left < right) {
//            right &= right - 1;
//        }
//        return right;
//    }

//    逻辑 -- 同时右移判断相同之后回退 shift 逻辑
    public static int rangeBitwiseAnd(int left , int right) {
        int shift = 0;
        while(left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left <<= shift;
    }
    public static void main(String[] args) {
        int ans = rangeBitwiseAnd(left, right);
        System.out.println("ans = " + ans);
    }
}
