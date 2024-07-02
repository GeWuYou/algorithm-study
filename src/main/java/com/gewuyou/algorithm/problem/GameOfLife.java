package com.gewuyou.algorithm.problem;

/**
 * 289. 生命游戏
 *
 * @author gewuyou
 * @since 2024-07-30 下午12:34:32
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {1, -1}, {1, 1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 判断当前格子是否存在活细胞
                bfs(board, direction, m, n, i, j);
            }
        }
        // 更新状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void bfs(int[][] board, int[][] direction, int m, int n, int i, int j) {
        // 遍历这个细胞四周
        // 如果是即将死亡的细胞标记为2，如果是即将复活的细胞标记为3
        int count = 0;
        for (int[] arr : direction) {
            int x = i + arr[0];
            int y = j + arr[1];
            if ((x >= 0 && x < m && y >= 0 && y < n) && (board[x][y] == 1 || board[x][y] == 2)) {
                count++;
            }
        }
        // 判断这个细胞是活细胞还是死细胞
        if (board[i][j] == 1) {
            if (count < 2 || count > 3) {
                board[i][j] = 2;
            }
        } else {
            if (count == 3) {
                board[i][j] = 3;
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        game.gameOfLife(board);
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
