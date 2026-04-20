package AboutArray;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc 1024 视频拼接
 *
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
 *
 * 甚至可以对这些片段自由地再剪辑：
 *
 * 例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 * @since Created in 2026-04-18
 */
public class Lc1024 {
    /**
     * 动态规划
     * @param clips
     * @param time
     * @return
     */
    public static int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        for (int i = 0; i <= time; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if(clip[0] < i && clip[1] >= i && dp[clip[0]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE ? -1 : dp[time];
    }

//    /**
//     * 贪心算法
//     * @param clips
//     * @param time
//     * @return
//     */
//    public static int videoStitching(int[][] clips, int time) {
//        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));
//        int n = clips.length;
//        int i = 0;
//
//        int count =0;
//        int curEnd = 0;
//        int nxtEnd = 0;
//        while(curEnd < time) {
//            while(i < n && clips[i][0] <= curEnd) {
//                nxtEnd = Math.max(nxtEnd, clips[i][1]);
//                i++;
//            }
//
//            if(nxtEnd <= curEnd) return -1;
//
//            curEnd = nxtEnd;
//            count++;
//        }
//        return count;
//    }



    public static void main(String[] args) {

    }
}
