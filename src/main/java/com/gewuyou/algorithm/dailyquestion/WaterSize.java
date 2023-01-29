package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 水域大小
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/22 14:23
 */
public class WaterSize {
    public int[] pondSizes(int[][] land) {
        int row = land.length;
        int cow = land[0].length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cow; j++) {
                if(land[i][j] == 0) {
                    result.add(dfs(land, i, j));
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    private int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        int result = 1;
        // 对该点的八个相邻点执行深度优先搜索
        for (int k = -1; k <= 1; k++) {
            for (int n = -1; n <= 1; n++) {
                // 跳过当前点
                if (k == 0 && n == 0) {
                    continue;
                }
                result += dfs(land, i + k, j + n);
            }
        }
        return result;
    }
}
