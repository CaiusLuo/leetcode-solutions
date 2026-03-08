package DoublePointer;

/**
 * @author Caius
 * @description LC 125 验证回文串
 *
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 * @since Created in 2026-03-08
 */
public class Lc125 {
    /**
     * ans = true
     */
//    private String s = "A man, a plan, a canal: Panama";
    /**
     * ans = false
     */
//    private String s = "race a car";
    /**
     * ans = true
     */
    private String s = " ";

    public boolean isPalindrome(String s){
        char[] str = s.toCharArray();

        int left = 0;
        int right = str.length - 1;

        while(left < right) {
            while(left < right && !isLatter(str[left])) left++;

            while(left < right && !isLatter(str[right])) right--;

            if(Character.toLowerCase(str[left]) != Character.toLowerCase(str[right])) return false;

            left++;
            right--;
        }
        return true;
    }

    private boolean isLatter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    public static void main(String[] args) {
        Lc125 solution = new Lc125();
        boolean palindrome = solution.isPalindrome(solution.s);
        System.out.println(palindrome);
    }
}
