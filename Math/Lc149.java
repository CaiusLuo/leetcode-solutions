package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Caius
 * @description Lc 149 直线上最多的点数
 *
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 * @since Created in 2026-04-04
 */
public class Lc149 {
    public static int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
    /**
     * 使用斜率加上 HashMap 实现数据 比较存储
     * @param points
     * @return
     */
    public static int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int gcd = gcd(dx, dy);
                String key = (dx / gcd) + "_" + (dy / gcd);
                map.put(key, map.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, map.get(key));
            }
            max = Math.max(max, localMax + 1);
        }
        return max;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int ans = maxPoints(points);
        System.out.println("ans = " + ans);
    }
}
