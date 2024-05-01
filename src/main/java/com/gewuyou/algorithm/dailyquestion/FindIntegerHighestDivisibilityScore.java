package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2644. 找出可整除性得分最大的整数
 *
 * @author gewuyou
 * @since 2024-05-18 下午1:11:53
 */
public class FindIntegerHighestDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        Map<Integer, Integer> map = new HashMap<>();
        int maxScore = 0;
        int maxDivisor = 0;
        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }
            map.put(divisor, score);
            if (score > maxScore) {
                maxScore = score;
                maxDivisor = divisor;
            }
        }
        // 判断分数是否都一样
        int count = 0;
        for (Integer value : map.values()) {
            if (value == maxScore) {
                count++;
            }
        }
        if(count==divisors.length||maxDivisor==0){
            return divisors[0];
        }
        return maxDivisor;
    }

    public static void main(String[] args) {
        FindIntegerHighestDivisibilityScore solution = new FindIntegerHighestDivisibilityScore();
        int[] nums = {12};
        int[] divisors = {10,16};
        System.out.println(solution.maxDivScore(nums, divisors));
    }
}

