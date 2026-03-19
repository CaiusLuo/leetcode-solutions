package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Caius
 * @description Lc 56 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @since Created in 2026-03-18
 */
public class Lc56 {

    private static int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);

        for(int i = 0; i < intervals.length; ++i) {
            int m = list.size();
            if(m != 0 && list.get(m - 1)[1] >= intervals[i][0]) {
                list.get(m - 1)[1] = Math.max(list.get(m - 1)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] merge = merge(intervals);
        for(int[] ans: merge){
            System.out.println(Arrays.toString(ans));
        }
    }
}
