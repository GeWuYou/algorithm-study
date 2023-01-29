package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 可被 K 整除的最小整数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SmallestIntegerDivisibleByK
 * @apiNote </br>
 * @since 2023/5/10 9:49
 */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        // 余数
        int remainder = 1 % k;
        // 正数位数
        int digits = 1;
        // 创建哈希表将余数加入其中
        Set<Integer> set = new HashSet<>();
        set.add(remainder);
        // 开始循环查找最小整数 当余数等于0时停止循环
        while (remainder != 0) {
            // 计算下一个余数
            remainder = (remainder * 10 + 1) % k;
            // 移动位数
            digits++;
            // 判断余数是否重复
            if(set.contains(remainder)) {
                return -1;
            }
            // 将当前余数加入集合
            set.add(remainder);
        }
        return digits;
    }
}
