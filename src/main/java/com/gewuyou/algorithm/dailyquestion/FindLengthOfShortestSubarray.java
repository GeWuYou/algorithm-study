package com.gewuyou.algorithm.dailyquestion;

/**
 * 删除最短的子数组使剩余数组有序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindLengthOfShortestSubarray
 * @apiNote </br>
 * @since 2023/3/25 12:14
 */
public class FindLengthOfShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        int right = length -1;
        // 将右指针移到不符合条件的位置
        while (right>0&&arr[right-1]<=arr[right]){
            right--;
        }
        // 如果右指针移到0说明数组严格非递减
        if(right==0){
            return 0;
        }
        // 此时arr[right-1]>arr[right]
        // 假设结果就是删除从0到right
        int result = right;
        // 从左开始寻找严格非递减的数组
        for (int left = 0; left == 0 || arr[left - 1]<=arr[left]; left++) {
            // 判断arr[right]与arr[left]
            while (right<length&&arr[right]<arr[left]){
                right++;
            }
            result = Math.min(result,right-left-1);
        }
        return result;
    }
}
