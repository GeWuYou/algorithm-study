package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口的最大值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumValueOfTheSlidingWindow
 * @apiNote </br>
 * @since 2023/1/8 14:14
 */
public class MaximumValueOfTheSlidingWindow {
    public List<Integer> maxInWindows(int[] num, int size) {
        // 创建集合存储滑动窗口的最大值
        List<Integer> windowMaximums = new ArrayList<>();
        // 对传入值做校验,窗口大于数组长度或窗口长度为0的时候，返回空集合(别问我为什么不返回null)。
        if (num.length < size || size == 0) {
            return windowMaximums;
        }
        // 创建变量标记窗口首位置
        int headLocation = 0;
        // 创建变量标记窗口最大值
        int windowMaximum = Integer.MIN_VALUE;
        // 使用while循环更新窗口首位置，窗口首位置不应超过数组长度减去窗口长度
        while (headLocation <= num.length - size) {
            // 使用for循环遍历窗口，寻找窗口最大值
            for (int i = headLocation; i < headLocation + size; i++) {
                if (windowMaximum < num[i]) {
                    windowMaximum = num[i];
                }
            }
            // 循环结束后更新窗口首位置
            headLocation++;
            // 将最大值加入集合
            windowMaximums.add(windowMaximum);
            // 重置最大值
            windowMaximum = Integer.MIN_VALUE;
        }
        return windowMaximums;
    }
}
