package BitwiseOperation;

/**
 * @author Caius
 * @description Lc191 位1的个数
 *
 * 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。
 *
 * @since Created in 2026-04-04
 */
public class Lc191 {
    /**
     * 逻辑是通过 num &= (num - 1) 消除最右边的 1 进行计算
     * @param num
     * @return
     */
    public static int hammingWeight(int num) {
        int count = 0;
        while(num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int ans = hammingWeight(2147483645);
        System.out.println("ans = " + ans);
    }
}
