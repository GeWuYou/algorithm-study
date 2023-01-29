package com.gewuyou.algorithm.swordpointstooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据流中的中位数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MedianFinder
 * @apiNote </br>
 * @since 2023/2/2 16:31
 */
public class MedianFinder {
    /**
     * 数据流集合
     */
    List<Integer> dataFlow;

    public MedianFinder() {
        dataFlow = new ArrayList<>();
    }

    public void addNum(int num) {
        if (dataFlow.isEmpty()) {
            // 数据流为空,直接加入集合
            dataFlow.add(num);
        } else {
            // 数据流不为空
            int index;
            // 寻找插入点
            for (index = 0; index < dataFlow.size(); index++) {
                // 找位置结束循环
                if (dataFlow.get(index) > num) {
                    break;
                }
            }
            dataFlow.add(index, num);
        }
    }

    public double findMedian() {
        // 计算当前集合大小
        int length = dataFlow.size();
        // 如果为奇数
        if ((length & 1) == 1) {
            return Double.valueOf(dataFlow.get(length / 2));
        } else {
            // 如果是偶数
            return (dataFlow.get(length / 2).doubleValue() + dataFlow.get(length / 2 - 1).doubleValue()) / 2;
        }
    }
}
