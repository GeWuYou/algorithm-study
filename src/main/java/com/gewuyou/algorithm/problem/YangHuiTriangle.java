package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author gewuyou
 * @since 2024-04-06 下午6:33:18
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }
        result.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 0; j <=i; j++) {
                if(j==0||j==i) {
                    list.add(1);
                }else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
