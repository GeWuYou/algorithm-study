package com.gewuyou.algorithm.problem;

/**
 * 1317. 将整数转换为两个无零整数的和
 *
 * @author gewuyou
 * @since 2024-05-23 下午3:31:14
 */
public class GetNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int a = 1,b = n-1;
        while (containsZero(a)||containsZero(b)){
            a++;
            b = n-a;
        }
        return new int[]{a,b};
    }
    public boolean containsZero(int number) {
        if (number == 0) {
            return true;
        }
        while (number > 0) {
            if (number % 10 == 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

}
