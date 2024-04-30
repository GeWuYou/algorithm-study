package com.gewuyou.algorithm.test;

import com.gewuyou.algorithm.sort.Radix;

/**
 * 基数排序测试类
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RadixTest
 * @apiNote </br>
 * @since 2022/10/23 17:59
 */
public class RadixTest {
    public static void main(String[] args) {
        int []arr = {53,3,542,748,14,214};
        Radix.sort(arr);
    }
}
