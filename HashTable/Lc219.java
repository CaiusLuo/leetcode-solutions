package HashTable;

import java.util.HashMap;

/**
 * @author Caius
 * @description LC 219 存在重复元素 II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * @since Created in 2026-03-18
 */
public class Lc219 {
    private static int[] nums = {1,2,3,1};
    private static int k = 3;

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean nearbyDuplicate = containsNearbyDuplicate(nums, k);

        System.out.println(nearbyDuplicate);
    }
}
