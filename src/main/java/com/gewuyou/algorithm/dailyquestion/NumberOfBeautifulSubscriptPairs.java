package com.gewuyou.algorithm.dailyquestion;

/**
 * 2748. 美丽下标对的数目
 *
 * @author gewuyou
 * @since 2024-06-20 下午4:19:46
 */
public class NumberOfBeautifulSubscriptPairs {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 获取第一位和最后一位数
                int first = String.valueOf(nums[i]).charAt(0)-'0';
                int last = String.valueOf(nums[j]).charAt(String.valueOf(nums[j]).length()-1)-'0';
                if (gcd(first, last) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
