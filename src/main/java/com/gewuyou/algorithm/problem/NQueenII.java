package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 52. N 皇后 II
 *
 * @author gewuyou
 * @since 2024-08-09 09:40:55
 */
public class NQueenII {
    public int totalNQueens(int n) {
        // 用于存储列的位置
        Set<Integer> columns = new HashSet<>();
        // 用于存储左对角线的位置
        Set<Integer> diagonals1 = new HashSet<>();
        // 用于存储右对角线的位置
        Set<Integer> diagonals2 = new HashSet<>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 如果所有行都已经放置了皇后，说明找到一个有效解
        if (row == n) {
            return 1;
        } else {
            int count = 0; // 计数器，记录有效解的数量
            for (int i = 0; i < n; i++) { // 遍历每一列，尝试放置皇后
                // 检查当前列是否已经有皇后
                if (columns.contains(i)) {
                    continue;
                }
                // 计算左对角线的索引，检查是否有皇后
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                // 计算右对角线的索引，检查是否有皇后
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                // 如果当前位置安全，放置皇后，并更新相关集合
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 递归调用，继续在下一行放置皇后
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                // 回溯，撤销放置的皇后
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count; // 返回找到的有效解数量
        }
    }
}
