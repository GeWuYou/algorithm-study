package com.gewuyou.algorithm.problem;

/**
 * 200. 岛屿数量
 *
 * @author gewuyou
 * @since 2024-05-19 上午10:54:14
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // 定义方向数组
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 定义访问数组
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前格子是陆地且没有访问过，则进行DFS
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j, directions);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int[][] directions) {
        // 标记当前格子已访问
        visited[i][j] = true;
        // 遍历四个方向
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            // 如果当前方向的格子是陆地且没有访问过，则进行DFS
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited[x][y]) {
                dfs(grid, visited, x, y, directions);
            }
        }
    }
}
