package BitwiseOperation;

/**
 * @author Caius
 * @description Lc137
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 * @since Created in 2026-04-04
 */
public class Lc137 {
    private static int[] nums = {0,1,0,1,0,1,99};
    public static int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        // 逻辑点 -- 1. 出现一次 且 在 two中间不存在 -- one
        //          2. 出现第二次 且 在 one 中间已经存在过并消除了
        for(int num: nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }

        return one;
    }
    public static void main(String[] args) {
        int ans = singleNumber(nums);
        System.out.println("ans = " + ans);
    }
}
