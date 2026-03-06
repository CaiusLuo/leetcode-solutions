/**
 * @author Caius
 * @description LC 55 跳跃游戏
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @since Created in 2026-03-06
 */
public class Lc55 {

    /**
     * ans true
     */
    private int[] nums = new int[]{2,3,1,1,4};
    /**
     * ans false
     */
//    private int[] nums = new int[]{3,2,1,0,4};

    /**
     * 判断数组是否能到达最后一个元素
     * 解法贪心算法 == 定义最大到达的位置，如果maxReach < i 的时候直接返回 false == 遍历nums
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        Lc55 solution = new Lc55();
        boolean canJump = solution.canJump(solution.nums);
        System.out.println(canJump);
    }
}
