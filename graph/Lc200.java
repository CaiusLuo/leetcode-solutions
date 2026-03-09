package graph;

/**
 * @author Caius
 * @description Lc 200
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * @since Created in 2026-03-09
 */
public class Lc200 {
    private char[][] grid = new char[][]{
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

    /**
     * 遍历 + dfs 实现岛屿数量判断
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int c, int l){
        if(c < 0 || l < 0 || c >= grid.length || l >= grid[0].length || grid[c][l] == '0') return;

        grid[c][l] = '0';

        dfs(grid, c + 1, l);
        dfs(grid, c - 1, l);
        dfs(grid, c, l - 1);
        dfs(grid, c, l + 1);
    }
    public static void main(String[] args) {
        Lc200 solution = new Lc200();
        int ans = solution.numIslands(solution.grid);
        System.out.println(ans);
    }
}
