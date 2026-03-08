package AboutArray;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-07
 */
public class Lc58 {
    /**
     * ans = 5
     */
//    private String s = "Hello World";
    /**
     * ans = 4
     */
//    private String s = "   fly me   to   the moon  ";
    /**
     * ans = 6
     */
    private String s = "luffy is still joyboy";

    // 優化版本：從右向左遍歷，時間複雜度更優
    public int lengthOfLastWord(String s) {
        int ans = 0;
        // 從右向左遍歷，跳過末尾的空格
        int i = s.length() - 1;

        // 跳過末尾的空格
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 計算最後一個單詞的長度
        while (i >= 0 && s.charAt(i) != ' ') {
            ans++;
            i--;
        }

        return ans;
    }

    // 原始版本：從左到右遍歷
    public int lengthOfLastWordOriginal(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i >= 1 && s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') {
                ans = 1;
            } else if(s.charAt(i) != ' ') {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Lc58 solution = new Lc58();

        // 測試優化後的版本
        int ans = solution.lengthOfLastWord(solution.s);
        System.out.println("優化版本結果: " + ans);

        // 測試原始版本
        int ansOriginal = solution.lengthOfLastWordOriginal(solution.s);
        System.out.println("原始版本結果: " + ansOriginal);
    }
}
