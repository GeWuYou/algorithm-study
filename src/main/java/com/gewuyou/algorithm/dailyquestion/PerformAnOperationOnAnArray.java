package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 对数组执行操作
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PerformAnOperationOnAnArray
 * @apiNote </br>
 * @since 2023/6/5 20:52
 */
public class PerformAnOperationOnAnArray {
    public int[] applyOperations(int[] nums) {
        int length = nums.length;
        if(length<2){
            return nums;
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
            if (nums[i - 1] == 0) {
                count++;
            } else {
                list.add(nums[i - 1]);
            }
        }
        if (nums[length - 1] == 0) {
            count++;
        } else {
            list.add(nums[length - 1]);
        }
        for (int i = 0; i < count; i++) {
            list.add(0);
        }
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
