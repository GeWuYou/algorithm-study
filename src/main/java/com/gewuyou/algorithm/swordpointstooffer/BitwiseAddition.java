package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 不用加减乘除做加法
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BitwiseAddition
 * @apiNote </br>
 * @since 2023/2/7 14:44
 */
public class BitwiseAddition {
    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while (b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }
}
