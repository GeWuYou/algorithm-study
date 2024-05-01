package com.gewuyou.algorithm.problem;

/**
 * 1275. 找出井字棋的获胜者
 *
 * @author gewuyou
 * @since 2024-05-21 下午5:32:38
 */
public class FindOutTheWinnerOfTicTacToe {
    public String tictactoe(int[][] moves) {
        // 提取A的操作
        int n = moves.length;
        char[][] board = new char[3][3];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                board[moves[i][0]][moves[i][1]] = 'X';
                count++;
            } else if ((i & 1) == 1) {
                board[moves[i][0]][moves[i][1]] = 'O';
                count++;
            }
        }
        // 判断是否有获胜者
        if (isWin(board, 'X')) {
            return "A";
        }
        if (isWin(board, 'O')) {
            return "B";
        }
        return count == 9 ? "Draw" : "Pending";
    }

    private boolean isWin(char[][] board, char x) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == x && board[i][1] == x && board[i][2] == x) {
                return true;
            }
            if (board[0][i] == x && board[1][i] == x && board[2][i] == x) {
                return true;
            }
        }
        if (board[0][0] == x && board[1][1] == x && board[2][2] == x) {
            return true;
        }
        return board[0][2] == x && board[1][1] == x && board[2][0] == x;
    }
}
