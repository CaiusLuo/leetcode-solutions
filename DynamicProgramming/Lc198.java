package DynamicProgramming;

/**
 * @author Caius
 * @description Lc198 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @since Created in 2026-04-05
 */
public class Lc198 {
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[]  dp = new int[nums.length  + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println("rob = " + rob);
    }
}
