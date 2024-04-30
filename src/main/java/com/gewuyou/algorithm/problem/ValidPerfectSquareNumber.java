package com.gewuyou.algorithm.problem;

/**
 * 367. 有效的完全平方数
 *
 * @author gewuyou
 * @since 2024-04-13 上午10:00:40
 */
public class ValidPerfectSquareNumber {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int t = num / mid;
            if (mid == t) {
                if (num % mid == 0) {
                    return true;
                } else {
                    left = mid + 1;
                }
            } else if (mid < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquareNumber solution = new ValidPerfectSquareNumber();
        System.out.println(solution.isPerfectSquare(5));
    }
}
