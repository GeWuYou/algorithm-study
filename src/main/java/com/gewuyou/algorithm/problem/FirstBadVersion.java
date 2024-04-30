package com.gewuyou.algorithm.problem;

/**
 * 第一个错误的版本
 *
 * @author gewuyou
 * @since 2024-04-11 下午1:09:44
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) {
        if (version >= 1) {
            return true;
        }
        return false;
    }
}
