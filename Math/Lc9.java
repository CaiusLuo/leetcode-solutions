package Math;

/**
 * @author Caius
 * @description lc9 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * @since Created in 2026-04-04
 */
public class Lc9 {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int reverseNumber = 0;
        int cur = x;
        while(cur > 0) {
            reverseNumber = reverseNumber * 10 + cur % 10;
            cur /= 10;
        }
        // 避免存在是奇数数位的数字
        return reverseNumber == x || x == reverseNumber / 10;
    }
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println("palindrome = " + palindrome);
    }
}
