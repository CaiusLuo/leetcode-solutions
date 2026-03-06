import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-06
 */
public class Lc274 {
    /**
     * ans = 3
     */
    private int[] citations = new int[]{3,0,6,1,5};
    /**
     * ans = 1
     */
//    private int[] citations = new int[]{1,3,1};

    /**
     * 解法使用排序之后判断后面数据是否符合HIndex数据
     * 使用排序是逆序排序
     * @param citations
     * @return
     */
//    public int HIndex(int[] citations) {
//        Arrays.sort(citations);
//        int ans = 0;
//        for(int i = citations.length - 1; i >= 0; i--) {
//            if(citations[i] > ans) ans++;
//        }
//        return ans;
//    }


    /**
     * 解法使用排序之后判断后面数据是否符合HIndex数据
     * 顺序解法
     * @param citations
     * @return
     */
    public int HIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        int n = citations.length;
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n-i) return n - i;
        }
        return 0;
    }
    public static void main(String[] args) {
        Lc274 solution = new Lc274();
        int ans = solution.HIndex(solution.citations);
        System.out.println(ans);
    }
}
