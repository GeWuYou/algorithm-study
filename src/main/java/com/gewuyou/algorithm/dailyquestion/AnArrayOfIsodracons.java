package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 等差子数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AnArrayOfIsodracons
 * @apiNote </br>
 * @since 2023/3/23 10:08
 */
public class AnArrayOfIsodracons {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int length = l.length;
        // 创建结果集合
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            equalDifference(result,nums,l[i],r[i]);
        }
        return result;
    }

    /**
     * 判断传入的索引对于数组是否为等差数列
     *
     * @param result 结果
     * @param nums 数组
     * @param left 左边界
     * @param right 右边界
     *
     * @apiNote
     * @since 2023/3/23 12:58
     */

    private void equalDifference(List<Boolean> result, int[] nums, int left, int right) {
        int[] temp = new int[right-left+1];
        System.arraycopy(nums, left, temp, 0, temp.length);
        Arrays.sort(temp);
        int tolerance = temp[1]-temp[0];
        for (int i = 1; i < temp.length; i++) {
            if(temp[i]-temp[i-1]!= tolerance){
                result.add(false);
                return;
            }
        }
        result.add(true);
    }
}
