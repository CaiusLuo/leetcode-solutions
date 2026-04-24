package DynamicProgramming;

/**
 * @author Caius
 * @description Lc 416 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @since Created in 2026-04-24
 */
public class Lc416 {
    /**
     * 二维动态数组实现解答
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum+=num;
        // 是否分成两份
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        // target == 0 全部可以拆分为 [][]
        for(int i = 0; i <= n; ++i) dp[i][0] = true;
        // 遍历数组元素 判断是否在 [0, n -1] 之间能实现分割
        for(int i = 1; i <= n; ++i){
            // 当前元素
            int val = nums[i - 1];
            // 这是遍历的 target
            for(int j = 1; j <= target; ++j) {
                // target < nums[cur] 装不下，继承上一个元素的状态
                if(j < val) dp[i][j] = dp[i - 1][j];
                // 只要上一个选的元素或者不选元素存在就实现分割
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
                // 提前结束
                if(dp[i][target]) return true;
            }
        }
        // 长度 n, 分割target能实现
        return dp[n][target];
    }

    /**
     * 一维动态数组实现解答
     * @param nums
     * @return
     */
    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                // 逆序 才不会覆盖 前面的状态
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
//        int[] nums = {1,2,3,5};
        boolean ans = canPartition1(nums);
        System.out.println("ans = " + ans);
    }
}
