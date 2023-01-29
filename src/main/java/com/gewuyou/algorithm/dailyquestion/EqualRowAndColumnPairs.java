package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 相等行列对
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName EqualRowAndColumnPairs
 * @apiNote </br>
 * @since 2023/6/6 20:43
 */
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // 将行元素转换为字符串加入集合中
        for (int[] ints : grid) {
            sb.delete(0, sb.length());
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(ints[j]).append(' ');
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        // 遍历列查找相同的元素
        for (int i = 0; i < grid[0].length; i++) {
            sb.delete(0, sb.length());
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]).append(' ');
            }
            result+=map.getOrDefault(sb.toString(),0);
        }
        return result;
    }
}
