package com.gewuyou.algorithm.dailyquestion;

/**
 * 2938. 区分黑球与白球
 *
 * @author gewuyou
 * @since 2024-06-06 下午2:49:48
 */
public class DistinguishBetweenBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        long count = 0;
        long blackCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                blackCount++;
            }else {
                count += blackCount;
            }
        }
        return count;
    }
}
