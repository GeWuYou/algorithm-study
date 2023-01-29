package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 矩阵中的路径
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PathsInTheMatrix
 * @apiNote </br>
 * @since 2023/1/31 11:46
 */
public class PathsInTheMatrix {
    public boolean exist(char[][] board, String word) {
        // 将字符串转为字符数组
        char[] words = word.toCharArray();
        // 遍历当前数组判断路径是否存在
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     *
     * @param row    行
     * @param column 列
     * @param index  字符串
     * @param board  矩阵
     * @param word   字符数组
     * @return boolean 结果
     * @apiNote
     * @since 2023/1/31 12:05
     */
    public boolean dfs(int row, int column, int index, char[][] board, char[] word) {
        // 行或列索引越界 当前矩阵元素已经访问过或者或者与目标字符不同
        if (row > board.length - 1 || column > board[0].length - 1 || row < 0 || column < 0 || board[row][column] != word[index]) {
            return false;
        }
        // 如果字符串遍历完成说明存在该路径
        if (index == word.length - 1) {
            return true;
        }
        // 标记当前元素
        board[row][column] = ' ';
        // 当前元素与目标元素相符则直接向上下左右进行下层递归
        boolean result =
                // 上
                dfs(row - 1, column, index + 1, board, word)
                        // 下
                        || dfs(row + 1, column, index + 1, board, word)
                        // 左
                        || dfs(row, column - 1, index + 1, board, word)
                        // 右
                        || dfs(row, column + 1, index + 1, board, word);
        // 还原当前矩阵，避免影响其他递归的判断
        board[row][column] = word[index];
        return result;
    }
}
