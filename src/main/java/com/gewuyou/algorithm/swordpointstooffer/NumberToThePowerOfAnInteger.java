package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 数值的整数次方
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberToThePowerOfAnInteger
 * @apiNote </br>
 * @since 2023/2/6 11:19
 */
public class NumberToThePowerOfAnInteger {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        // 当n为负数时，执行取反可能会越界，需要使用龙防止越界
        long power = n;
        double result = 1.0;
        // 如果n为负数，需要将x取倒数
        if(power<0){
            x=1/x;
            // 对次方数取反
            power = -power;
        }
        while (power>0){
            // 判断次方奇偶
            if (((power & 1) == 1)) {
                // 当次方数为奇数时先乘掉一个x
                result *= x;
            }
            x *= x;
            // 将n后移一位
            power >>= 1;
        }
        return result;
    }
}
