package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Caius
 * @description Lc57 插入区间
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 * @since Created in 2026-03-19
 */
public class Lc57 {

    private static int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    private static int[] newInterval = {4,8};

    /**
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        while(i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] insert = insert(intervals, newInterval);
        for(int[] ans: insert){
            System.out.println(Arrays.toString(ans));
        }
    }
}
