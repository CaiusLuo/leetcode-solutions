/**
 * @author Caius
 * @description Lc 134
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * @since Created in 2026-03-07
 */
public class Lc134 {
    /**
     * ans = 3
     */
    private int[] gas = new int[]{1,2,3,4,5};
    private int[] cost = new int[]{3,4,5,1,2};
    /**
     * ans = -1
     */
//    private int[] gas = new int[]{2,3,4};
//    private int[] cost = new int[]{3,4,3};

    /**
     * 贪心算法 -- 贪心枝剪操作
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
    public static void main(String[] args) {
        Lc134 solution = new Lc134();
        int ans = solution.canCompleteCircuit(solution.gas, solution.cost);
        System.out.println(ans);
    }
}
