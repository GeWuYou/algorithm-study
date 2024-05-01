package com.gewuyou.algorithm.problem;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * @author gewuyou
 * @since 2024-05-21 下午6:07:44
 */
public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for (int i = 0,len = n/4; i < n-len; i++) {
            if(arr[i] == arr[i+len]){
                return arr[i];
            }
        }
        return arr[0];
        // int count = 0;
        // int n = arr.length;
        // if (n == 1) {
        //     return arr[0];
        // }
        // List<Integer> result = new ArrayList<>();
        // for (int i = 0; i < n - 1; i++) {
        //     if (arr[i] == arr[i + 1]) {
        //         count++;
        //         if ((n & 1) == 0) {
        //             if (count >= n / 4) {
        //                 result.add(arr[i]);
        //             }
        //
        //         } else {
        //             if (count >= n / 4 + 1) {
        //                 result.add(arr[i]);
        //             }
        //         }
        //
        //     } else {
        //         count = 1;
        //     }
        // }
        // Collections.sort(result);
        // return result.getLast();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,3};
        FindSpecialInteger fsi = new FindSpecialInteger();
        System.out.println(fsi.findSpecialInteger(arr));
    }
}
