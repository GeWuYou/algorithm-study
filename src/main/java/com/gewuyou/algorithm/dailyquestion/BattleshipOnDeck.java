package com.gewuyou.algorithm.dailyquestion;

/**
 * 419. 甲板上的战舰
 *
 * @author gewuyou
 * @since 2024-06-11 下午7:50:17
 */
public class BattleshipOnDeck {
    public int countBattleships(char[][] board) {
        int count = 0;
        int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j, m, n,directions);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int i, int j, int m, int n, int[][] directions) {
        board[i][j] = 'F';
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'X') {
                dfs(board, x, y, m, n, directions);
            }
        }
    }
}
