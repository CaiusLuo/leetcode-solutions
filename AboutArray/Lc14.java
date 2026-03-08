package AboutArray;

/**
 * @author Caius
 * @description Lc 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @since Created in 2026-03-08
 */
public class Lc14 {
    /**
     * ans = "fl"
     */
    private String[] str = {"flower","flow","flight"};
    /**
     * ans = ""
     */
//    private String[] str = {"dog","racecar","car"};

    /**
     * 最长前缀字符串
     * @return
     */
    public String prefix(String[] str){
        if(str.length == 0 || str == null) return "";
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            int j = 0;
            while(
                j < str[i].length()
                && j < prefix.length()
                && prefix.charAt(j) == str[i].charAt(j)
            ){
                j++;
            }
            prefix = prefix.substring(0, j);
            if(prefix.length() == 0) return "";
        }
        return prefix;
    }
    public static void main(String[] args) {
        Lc14 solution = new Lc14();
        String prefix = solution.prefix(solution.str);
        System.out.println(prefix);
    }
}
