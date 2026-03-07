package AboutArray;

/**
 * @author Caius
 * @description Lc 45 跳跃游戏 II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 *
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 *
 * @since Created in 2026-03-06
 */
public class Lc45 {

    /**
     * ans = 2
     */
    private int[] nums = new int[]{2,3,1,1,4};
    /**
     * ans = 2
     */
//    private int[] nums = new int[]{2,3,1,1,4};

    /**
     * 区间扩展贪心（Greedy + BFS Layer Expansion）
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int maxReach = 0;
        int end = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 实际是保留一层数据的最大值
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == end) {
                steps ++;
                end = maxReach;
            }
        }

        return steps;
    }
    public static void main(String[] args) {
        Lc45 solution = new Lc45();
        int jump = solution.jump(solution.nums);
        System.out.println(jump);
    }
}
