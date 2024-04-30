package com.gewuyou.algorithm.problem;

/**
 * 有效的数独
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ValidSudoku
 * @apiNote 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * </br>1、数字1-9在每一行只能出现一次。
 * </br>2、数字1-9在每一列只能出现一次。
 * </br>3、数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * </br>注意：
 * </br>1、一个有效的数独（部分已被填充）不一定是可解的。
 * </br>2、只需要根据以上规则，验证已经填入的数字是否有效即可。
 * </br> 空白格用'.'表示。
 * @since 2022/10/7 15:26
 */
public class ValidSudoku {
    /**
     * @param board 数独数组
     * @return boolean 结果
     * @apiNote
     * @since 2022/10/7 15:46
     */
    public boolean isValidSudoku(char[][] board) {
        // 记录行数
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        // 行
        int[][] line = new int[length][length];
        // 列
        int[][] column = new int[length][length];
        // 单元格
        int[][] cell = new int[length][length];
        // 遍历数独数组
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') {
                    continue;
                }
                // 当前格子元素
                int num = board[i][j] - '0' - 1;
                // 计算当前所在单元格
                int k = i / 3 * 3 + j / 3;
                // 如果该元素所在行 所在列 所在单元格 存在该元素
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0) {
                    return false;
                }
                // 如果该元素在相关标记数组中不存在则将其加入
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }
}