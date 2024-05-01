package com.gewuyou.algorithm.problem;

/**
 * 130. 被围绕的区域
 *
 * @author gewuyou
 * @since 2024-05-07 下午7:27:53
 */
public class AreaThatIsSurrounded {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        // 遍历数组

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // 查找与之相领的O
        // 判断边界
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        // 将当前值设置为标记
        board[i][j] = 'A';
        // 递归查找周围的O
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

}
