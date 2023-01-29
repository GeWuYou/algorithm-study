package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 三数之和
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheSumOfTheThreeNumbers
 * @apiNote </br>
 * @since 2023/1/16 19:00
 */
public class TheSumOfTheThreeNumbers {
    public List<ArrayList<Integer>> threeSum(int[] num) {
        // 创建结构集合
        List<ArrayList<Integer>> result = new ArrayList<>();
        // 对数组进行判空
        if (num.length == 0) {
            return result;
        }
        // 对数组进行排序
        Arrays.sort(num);
        // 定义两个指针
        int former;
        int after;
        // 遍历数组
        for (int i = 0; i < num.length; i++) {
            former = i + 1;
            after = num.length - 1;
            while (former < after) {
                // 如果等于
                if (num[i] + num[former] + num[after] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[former]);
                    temp.add(num[after]);
                    result.add(temp);
                    after--;
                    former++;
                }
                // 如果大于移动after
                else if (num[i] + num[former] + num[after] > 0) {
                    after--;
                }
                // 如果小于移动former
                else {
                    former++;
                }
            }
        }
        // 去重
        Set<ArrayList<Integer>> temporary = new LinkedHashSet<>(result);
        result.clear();
        result.addAll(temporary);
        return result;
    }
}
