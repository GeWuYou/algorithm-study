package com.gewuyou.algorithm.dailyquestion;

/**
 * 买钢笔和铅笔的方案数
 *
 * @author gewuyou
 */
public class WaysToBuyPensPencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost2 > cost1) {
            int temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }
        long result = 0;
        long count = 0;
        while (count * cost1 <= total) {
            result += (total - count * cost1) / cost2 + 1;
            count++;
        }
        return result;
    }
}
