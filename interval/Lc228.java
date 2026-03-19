package interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 228 汇总区间
 *
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @since Created in 2026-03-19
 */
public class Lc228 {

//    private static int[] nums = {0,1,2,4,5,7};

    private static int[] nums = {0,2,3,4,6,8,9};
    public static List<String> summeryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int slow = 0;
        for(int fast = 1; fast <= nums.length; ++fast) {
            if(fast == nums.length || nums[fast - 1] + 1 != nums[fast]) {
                if(fast - 1 == slow) {
                    ans.add(String.valueOf(nums[slow]));
                } else {
                    ans.add(nums[slow] + "->" + nums[fast - 1]);
                }
                slow = fast;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> strings = summeryRanges(nums);
        for(String str: strings) {
            System.out.print(str + " ");
        }
    }
}
