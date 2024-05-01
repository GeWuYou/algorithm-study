package com.gewuyou.algorithm.dailyquestion;

/**
 * 2028. 找出缺失的观测数据
 *
 * @author gewuyou
 * @since 2024-05-27 下午2:46:57
 */
public class FindOutTheMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // 计算rolls的和
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        // 计算缺失的和
        int total = (rolls.length+n) * mean;
        // 每个骰子的最小值为1
        // 每个骰子的最大值为6
        int maxPossibleSum = n * 6;
        if(sum+maxPossibleSum<total||sum+ n >total){
            return new int[0];
        }
        // 创建缺失数组
        int[] missing = new int[n];
        int remainingSum = total - sum;
        for (int i = 0; i < n; i++) {
          int maxPossibleValue = Math.min(6, remainingSum-(n-i-1));
          int minPossibleValue = Math.max(1, remainingSum-(n-i-1)*6);
          missing[i] = (maxPossibleValue+minPossibleValue)/2;
          remainingSum -= missing[i];
        }
        return missing;
    }
}