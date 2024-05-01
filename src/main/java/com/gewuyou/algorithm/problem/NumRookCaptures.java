package com.gewuyou.algorithm.problem;

/**
 * 999. 可以被一步捕获的棋子数
 *
 * @author gewuyou
 * @since 2024-05-12 下午2:51:15
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int currX = 0;
        int currY = 0;
        // 寻找车的位置
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    currX = i;
                    currY = j;
                }
            }
        }
        // 方向数组
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int x = currX;
            int y = currY;
            while (true) {
                x += dx[i];
                y += dy[i];
                // 到达边缘或者遇到友方象，停止搜索
                if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                    break;
                }
                if (board[x][y] == 'p') {
                    count++;
                    break;
                }

            }
        }
        return count;
    }
}
