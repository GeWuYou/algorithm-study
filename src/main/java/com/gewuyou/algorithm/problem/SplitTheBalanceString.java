package com.gewuyou.algorithm.problem;

/**
 * 1221. 分割平衡字符串
 *
 * @author gewuyou
 * @since 2024-05-20 下午1:16:05
 */
public class SplitTheBalanceString {
    public int balancedStringSplit(String s) {
        int count = 0;
        int RCount = 0;
        int LCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                RCount++;
            } else {
                LCount++;
            }
            if(RCount == LCount){
                count++;
                RCount = 0;
                LCount = 0;
            }
        }
        return count;
    }
}
