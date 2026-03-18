package HashTable;

import java.util.HashSet;

/**
 * @author Caius
 * @description Lc 128 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @since Created in 2026-03-18
 */
public class Lc128 {

//    private static int[] nums = {100,4,200,1,3,2};
    private static int[] nums = {0,3,7,2,5,8,4,6,0,1};

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num: nums) {
            set.add(num);
        }

        for(int num: set) {
            if(!set.contains(num - 1)) {
                int curNum = num;
                int count = 1;
                while(set.contains(curNum + 1)) {
                    curNum++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }
}
