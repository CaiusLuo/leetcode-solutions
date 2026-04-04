package BitwiseOperation;

/**
 * @author Caius
 * @description Lc67 二进制求和
 *
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * @since Created in 2026-04-04
 */
public class Lc67 {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int curr = 0;
        int sum = 0;
        StringBuilder res = new StringBuilder();

        while(i >= 0 || j >= 0 || curr != 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            sum = curr + x + y;

            res.append(sum % 2);
            curr = sum / 2;
            i--;
            j--;
        }
        // 添加字符串顺序需要反转
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String arr1 = new String("1010");
        String arr2 = new String("1011");
        String res = addBinary(arr1, arr2);
        System.out.println("res = " + res);

        int c = 12;
        byte parseByte = Byte.parseByte("12");

    }
}
