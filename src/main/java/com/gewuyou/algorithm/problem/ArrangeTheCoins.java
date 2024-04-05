package com.gewuyou.algorithm.problem;

/**
 * 441. 排列硬币
 *
 * @author gewuyou
 * @since 2024-04-16 下午12:48:45
 */
public class ArrangeTheCoins {
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = ((long) mid * (mid + 1)) / 2;
            if (sum == n) {
                return mid;
            } else if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {

        ArrangeTheCoins solution = new ArrangeTheCoins();
        int result = solution.arrangeCoins(1804289383);

        System.out.println(result);
    }
}
