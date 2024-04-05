package com.gewuyou.algorithm.problem;

/**
 * 79. 单词搜索
 *
 * @author gewuyou
 * @since 2024-04-23 下午6:37:09
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 判断四周能够组成单词
                if (dfs(board, chars, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int index, int i, int j, boolean[][] visited) {
        // 已经找到单词
        if (index == chars.length) {
            return true;
        }
        // 越界或者已经访问过或者当前字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != chars[index]) {
            return false;
        }
        // 标记已经访问过
        visited[i][j] = true;
        // 向四周的四个方向继续搜索
        boolean res = dfs(board, chars, index + 1, i + 1, j, visited) ||
                dfs(board, chars, index + 1, i - 1, j, visited) ||
                dfs(board, chars, index + 1, i, j + 1, visited) ||
                dfs(board, chars, index + 1, i, j - 1, visited);
        // 回溯
        visited[i][j] = false;
        return res;
    }


}
