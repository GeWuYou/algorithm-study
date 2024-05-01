package com.gewuyou.algorithm.dailyquestion;

/**
 * 2960. 统计已测试设备
 *
 * @author gewuyou
 * @since 2024-05-10 上午9:39:51
 */
public class CountTheDevicesThatHaveBeenTested {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        int n = batteryPercentages.length;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                decrease(i + 1, n - 1, batteryPercentages);
            }
        }
        return count;
    }

    private void decrease(int i, int n, int[] batteryPercentages) {
        for (int j = i; j <= n; j++) {
            batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
        }
    }

    public static void main(String[] args) {
        int[] batteryPercentages = {1,2,0};
        CountTheDevicesThatHaveBeenTested solution = new CountTheDevicesThatHaveBeenTested();
        int result = solution.countTestedDevices(batteryPercentages);
        System.out.println(result);
    }
}
