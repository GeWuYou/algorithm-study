package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 统计字典序元音字符串的数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CountVowelStrings
 * @apiNote </br>
 * @since 2023/3/29 9:24
 */
public class CountVowelStrings {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }


}
