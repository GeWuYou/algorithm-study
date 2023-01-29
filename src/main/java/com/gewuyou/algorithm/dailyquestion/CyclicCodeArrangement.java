package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环码排列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CyclicCodeArrangement
 * @apiNote </br>
 * @since 2023/2/23 14:41
 */
public class CyclicCodeArrangement {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;
    }
}

