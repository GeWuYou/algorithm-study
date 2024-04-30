package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 求1到n的和
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindTheSumFromOneToN
 * @apiNote </br>
 * @since 2023/2/4 11:57
 */
public class FindTheSumFromOneToN {
    public int sumNums(int n) {
        boolean temp = (n > 1) && (((n += sumNums(n - 1))) > 0);
        return n;
    }
}
