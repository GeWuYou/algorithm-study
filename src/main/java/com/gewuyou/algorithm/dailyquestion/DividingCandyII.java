package com.gewuyou.algorithm.dailyquestion;

/**
 * 1103. 分糖果 II
 *
 * @author gewuyou
 * @since 2024-05-17 下午5:38:34
 */
public class DividingCandyII {
    public int[] distributeCandies(int candies, int num_people) {
            int[] result = new int[num_people];
            int base = 1;
            int index = 0;
            while (candies > 0) {
                result[index] += Math.min(base, candies);
                candies -= base;
                base++;
                index = (index + 1) % num_people;
            }
            return result;
    }
}
