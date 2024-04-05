package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 *
 * @author gewuyou
 * @since 2024-04-05 下午6:16:48
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        // 初始默认第一行
        int index = 0;
        boolean reverse = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(index).append(s.charAt(i));
            if(reverse){
                if(index==0){
                    index++;
                    reverse = false;
                }else {
                    index--;
                }
            }else {
                if (index == numRows - 1) {
                    reverse = true;
                    index--;
                } else {
                    index++;
                }
            }

        }
        rows.forEach(result::append);
        return result.toString();
    }
}
