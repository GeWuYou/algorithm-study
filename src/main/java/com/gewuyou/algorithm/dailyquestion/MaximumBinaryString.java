package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 修改后的最大二进制字符串
 *
 * @author gewuyou
 * @since 2024-04-10 上午10:42:40
 */
public class MaximumBinaryString {
    public String maximumBinaryString(String binary) {
        char[] binaryArray = binary.toCharArray();
        List<Integer> zeroIndex = new ArrayList<>(2);
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == '1') {
                continue;
            }
            // 判断是否是连续的0
            if (!zeroIndex.isEmpty() && i - zeroIndex.get(0) == 1) {
                binaryArray[i - 1] = '1';
                binaryArray[i] = '0';
                zeroIndex.set(0, i);
            } else if (zeroIndex.isEmpty()) {
                zeroIndex.add(i);
            } else {
                int index = zeroIndex.get(0);
                binaryArray[index] = '1';
                binaryArray[index + 1] = '0';
                binaryArray[i] = '1';
                zeroIndex.set(0, index + 1);
            }
        }
        return new String(binaryArray);
    }
}
