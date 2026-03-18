package HashTable;

/**
 * @author Caius
 * @description Lc 202 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * @since Created in 2026-03-18
 */
public class Lc202 {

    private static int n = 19;

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != slow && fast != 1) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }

        return fast == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        while(num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        boolean happy = isHappy(n);
        System.out.println(happy);
    }
}
