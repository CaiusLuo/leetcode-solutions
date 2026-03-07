package AboutArray;

/**
 * @author Caius
 * @description Lc42 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @since Created in 2026-03-07
 */
public class Lc42 {
    /**
     * ans = 6
     */
    private int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    /**
     * ans = 9
     */
//    private int[] height = new int[]{4,2,0,3,2,5};

    /**
     * 接雨水,实际只是需要判断最大高度和height[]之间的差值之和
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc42 solution = new Lc42();
        int ans = solution.trap(solution.height);
        System.out.println(ans);
    }
}
