package AboutArray;

/**
 * @author Caius
 * @description Lc 135 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * @since Created in 2026-03-07
 */
public class Lc135 {
    /**
     * ans = 5
     */
//    private int[] rating = new int[]{1,0,2};
    /**
     * ans = 4
     */
    private int[] rating = new int[]{1,2,2};

    /**
     * 相邻比较算法
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
//      初始化每个人最少都拿一颗candy
        for(int i = 0; i < ratings.length; i++){
            candies[i] = 1;
        }
//      遍历左边的糖果分配
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
//       遍历右边的糖果 == 获取最适合分配逻辑
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int total = 0;
        for(int i = 0; i < candies.length; i++){
            total += candies[i];
        }
        return total;
    }
    public static void main(String[] args) {
        Lc135 solution = new Lc135();
        int candies = solution.candy(solution.rating);
        System.out.println(candies);
    }
}
