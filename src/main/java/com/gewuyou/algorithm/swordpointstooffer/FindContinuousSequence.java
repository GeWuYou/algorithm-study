package com.gewuyou.algorithm.swordpointstooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为 s 的连续正数序列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindContinuousSequence
 * @apiNote </br>
 * @since 2023/2/15 21:18
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        // 左边界
        int leftBorder = 1;
        // 右边界
        int rightBorder = 2;
        // 元素和
        int sum = 3;
        while (leftBorder < rightBorder) {
            // 当和等于目标值时记录连续整数序列
            if (sum == target) {
                // 记录连续整数序列
                int[] ans = new int[rightBorder - leftBorder + 1];
                for (int i = leftBorder; i <= rightBorder; i++) {
                    ans[i - leftBorder] = i;
                }
                result.add(ans);
            }
            // 当和大于目标值时向右移动左边界并更新元素和
            if (sum >= target) {
                // 将左边界值移除和中
                sum -= leftBorder;
                // 移除和之后再向右移动左边界
                leftBorder++;
            }
            // 当和小于目标值时向右移动右边界并更新元素和
            else {
                // 向右移动右边界
                rightBorder++;
                // 将自增后的右边界值加入和中
                sum += rightBorder;
            }
        }
        // 最后返回结果集合
        return result.toArray(new int[0][]);
    }
}
