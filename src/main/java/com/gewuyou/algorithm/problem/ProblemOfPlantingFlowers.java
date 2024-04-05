package com.gewuyou.algorithm.problem;

/**
 * 605. 种花问题
 *
 * @author gewuyou
 * @since 2024-04-25 下午2:10:32
 */
public class ProblemOfPlantingFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (n == 0) {
            return true;
        }
        if (length == 1) {
            return flowerbed[0] == 0;
        }
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                // 左边界
                if (i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                // 右边界
                else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                // 其他位置
                else if (i - 1 >= 0 && i + 1 < length && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
