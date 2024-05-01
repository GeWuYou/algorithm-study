package com.gewuyou.algorithm.dailyquestion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @author gewuyou
 * @since 2024-05-13 上午9:52:07
 */
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        int total = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        // 找到当前所有烂苹果的位置并加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] != 0){
                    total++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    count++;
                }
            }
        }
        // 通过队列遍历所有烂苹果并将它周围的不是烂苹果的位置就加入队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    // 获取其他位置
                    assert cur != null;
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                        count++;
                        hasRotten = true;
                    }
                }
            }
            if (hasRotten) {
                time++;
            }
        }
        return count == total?  time: -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {0,1,1}, {1, 0, 1}};
        RottenOranges rottenOranges = new RottenOranges();
        int result = rottenOranges.orangesRotting(grid);
        System.out.println(result);
    }
}
