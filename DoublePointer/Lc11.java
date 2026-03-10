package DoublePointer;

/**
 * @author Caius
 * @description Lc 11 装最多水的容器
 * @since Created in 2026-03-10
 */
public class Lc11 {
    /**
     * ans = 49
     */
    private int[] height = {1,8,6,2,5,4,8,3,7};

    /**
     * 双指针遍历出 ans
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int ans = 0;
        while(left < right){
            if(height[left] < height[right]) {
                ans = Math.max(ans, (right - left) * height[left]);
                left ++;
            } else {
                ans = Math.max(ans, (right - left) * height[right]);
                right--;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Lc11 solution = new Lc11();
        int ans = solution.maxArea(solution.height);
        System.out.println(ans);
    }
}
