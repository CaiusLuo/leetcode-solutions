import java.util.*;

/**
 * @author Caius
 * @description Lc380 实现RandomizedSet
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * @since Created in 2026-03-07
 */

public class RandomizedSet{
    private List<Integer> nums;
    private Map<Integer, Integer> map;
    private Random random;

     public RandomizedSet() {
         nums = new ArrayList<>();
         map = new HashMap<>();
         random = new Random();
    }

    /**
     * 插入参数
     * @param val
     * @return
     */
    public boolean insert(int val) {
         if(map.containsKey(val)) return false;
         nums.add(val);
         map.put(val, nums.size() - 1);
         return true;
    }

    /**
     * 删除元素
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
//        swap + listRemove
        int idx = map.get(val);
        int last = nums.get(nums.size() - 1);

        nums.set(idx, last);
        map.put(last, idx);

        nums.remove(nums.size() - 1);
        map.remove(val);

        return true;
    }

    /**
     * 获取随机元素
     * @return
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
