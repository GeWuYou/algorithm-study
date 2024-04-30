package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出给定方程的正整数解
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindThePositiveIntegerSolutionOfTheEquation
 * @apiNote </br>
 * @since 2023/2/18 19:30
 */
public class FindThePositiveIntegerSolutionOfTheEquation {
    interface CustomFunction {
        public int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 创建结果集合
        List<List<Integer>> result = new ArrayList<>();
        // 固定x寻找合适的y值
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            // 寻找适合的y值
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                result.add(temp);
            }
        }
        return result;
    }
}
