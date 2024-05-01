package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1089. 复写零
 *
 * @author gewuyou
 * @since 2024-05-16 下午4:39:26
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (j == 0) {
                list.add(0);
                list.add(0);
            } else {
                list.add(j);
            }
        }
        for (Integer i : list) {
            arr[index++] = i;
            if(index == arr.length){
                break;
            }
        }
    }
}
