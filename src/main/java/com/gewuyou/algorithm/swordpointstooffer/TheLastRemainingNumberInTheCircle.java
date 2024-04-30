package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 圆圈中最后剩下的数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheLastRemainingNumberInTheCircle
 * @apiNote </br>
 * @since 2023/2/15 22:54
 */
public class TheLastRemainingNumberInTheCircle {
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result+m)%i;
        }
        return result;
    }
}
