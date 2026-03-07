package AboutArray;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-07
 */
public class Lc238 {

    /**
     * ans: [24,12,8,6]
     */
//    private int[] nums = new int[]{1,2,3,4};
    /**
     * ans: [0,0,9,0,0]
     */
    private int[] nums = new int[]{-1,1,0,-3,3};

//    /**
//     * 前缀和实现【时间复杂度O(n)和空间复杂度为O(n)】
//     * @param nums
//     * @return
//     */
//    public int[] productExceptSelf(int[] nums){
//        int n = nums.length;
//        int[] ans = new int[n];
//        int[] right = new int[n];
//        int[] left = new int[n];
//
//        left[0] = 1;
//        for(int i=1;i<n;i++){
//            left[i] = left[i-1]*nums[i-1];
//        }
//
//        right[n-1] = 1;
//        for(int i=n-2;i>=0;i--){
//            right[i] = right[i+1]*nums[i+1];
//        }
//
//        for(int i=0;i<n;i++){
//            ans[i] = left[i]*right[i];
//        }
//        return ans;
//    }

    /**
     * 空间优化为O(1)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }

        int right = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Lc238 solutions = new Lc238();
        int[] ans = solutions.productExceptSelf(solutions.nums);
        System.out.print("[");
        for(int num: ans){
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
