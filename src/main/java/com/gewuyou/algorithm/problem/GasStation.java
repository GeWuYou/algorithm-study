package com.gewuyou.algorithm.problem;

/**
 * 134. 加油站
 *
 * @author gewuyou
 * @since 2024-05-08 下午1:16:15
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int [] fuelTank = new int[n];
        // 计算油耗
        for (int i = 0; i < fuelTank.length; i++) {
            fuelTank[i] = gas[i] - cost[i];
        }
        // 计算总油量
        int totalFuel = 0;
        for (int j : fuelTank) {
            totalFuel += j;
        }
        if(totalFuel < 0) {
          return -1;
        }
        // 寻找起始加油站
        int start = 0;
        int currentFuel = 0;
        for (int i = 0; i < n; i++) {
            currentFuel += fuelTank[i];
            if (currentFuel < 0) {
                currentFuel = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
