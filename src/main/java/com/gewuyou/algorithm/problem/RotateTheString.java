package com.gewuyou.algorithm.problem;

/**
 * 796. 旋转字符串
 *
 * @author gewuyou
 * @since 2024-05-02 下午1:36:51
 */
public class RotateTheString {
    public boolean rotateString(String s, String goal) {
        return   s.length() == goal.length() && (s + s).contains(goal);
    }
}
