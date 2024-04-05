package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 *
 * @author gewuyou
 * @since 2024-04-14 下午1:38:37
 */
public class BinaryWatches {
    public List<String> readBinaryWatch(int turnedOn) {
      List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if(Integer.bitCount(h)+Integer.bitCount(m)==turnedOn){
                    result.add(h+":"+(m<10?"0":"")+m);
                }
            }
        }
        return result;
    }
}
