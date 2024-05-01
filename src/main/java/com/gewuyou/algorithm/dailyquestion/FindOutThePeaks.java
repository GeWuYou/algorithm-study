package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 2951. 找出峰值
 *
 * @author gewuyou
 * @since 2024-05-28 下午4:40:14
 */
public class FindOutThePeaks {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        int n = mountain.length;
        for (int i = 1; i < n-1; i++) {
            if(mountain[i]>mountain[i-1] && mountain[i]>mountain[i+1]){
                result.add(i);
            }
        }
        return result;
    }

}
