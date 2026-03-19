package interval;

import java.util.Arrays;

/**
 * @author Caius
 * @description Lc452 用最少的箭引爆最多气球
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * @since Created in 2026-03-19
 */
public class Lc452 {

    private static int[][] points = {{10,16},{2,8},{1,6},{7,12}};

    /**
     * 思路
     * 1. 实现排序
     * 2. 贪心 【从第一个开始计算】
     * 3. 比较递增数据
     * @param point
     * @return
     */
    public static int findMinArrowShots(int[][] point) {
        if(point.length == 0) return 0;
        // 比较数据 通过 point[1] 实现最右边的 eadg 实现判断
        Arrays.sort(point, (p, q) -> Integer.compare(p[1], q[1]));

        int end = point[0][1];

        int count = 1;

        for(int i = 0; i < point.length; ++i) {
            if(point[i][0] > end) {
                end = point[i][1];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}
