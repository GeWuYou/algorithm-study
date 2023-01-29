package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据流中的中位数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MedianInTheDataStream
 * @apiNote </br>
 * @since 2023/1/13 17:12
 */
public class MedianInTheDataStream {
    List<Integer> nums = new ArrayList<>();

    /**
     * 数据流读取方法
     *
     * @param num 数据
     * @apiNote
     * @since 2023/1/14 13:45
     */
    public void Insert(Integer num) {
        if (nums.isEmpty()) {
            // 将数据加入集合中
            nums.add(num);
        } else {
            // 让集合有序
            int index = 0;
            // 寻找插入点
            for (; index < nums.size(); index++) {
                if (num <= nums.get(index)) {
                    break;
                }
            }
            // 将数据插入相应位置
            nums.add(index, num);
        }
    }

    public Double GetMedian() {
        // 计算当前集合大小
        int length = nums.size();
        // 如果为奇数
        if (length % 2 == 1) {
            return Double.valueOf(nums.get(length / 2));
        } else {
            // 如果是偶数
            return (nums.get(length / 2).doubleValue() + nums.get(length / 2 - 1).doubleValue()) / 2;
        }
    }
}
