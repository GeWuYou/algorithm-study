package com.gewuyou.algorithm.dailyquestion;

/**
 * 1299. 将每个元素替换为右侧最大元素
 *
 * @author gewuyou
 * @since 2024-05-22 下午12:17:25
 */
public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        arr[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if(max < temp){
                max = temp;
            }
        }
        return arr;
    }
}
