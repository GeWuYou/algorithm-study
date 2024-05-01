package com.gewuyou.algorithm.problem;

/**
 * 844. 比较含退格的字符串
 *
 * @author gewuyou
 * @since 2024-05-04 上午11:22:29
 */
public class CompareStringsWithBackspace {
    public boolean backspaceCompare(String s, String t) {
        char backspace = '#';
        int i = s.length() - 1, j = t.length() - 1;
        int sBack = 0, tBack = 0; // 用于记录 s 和 t 中退格符的数量
        while (i >= 0 || j >= 0) {
            // 统计 s 中当前位置及之前的退格符数量
            while (i >= 0 && (s.charAt(i) == backspace || sBack > 0)) {
                // 遇到退格符，退格符数量 +1
                if (s.charAt(i) == backspace) {
                    sBack++;
                }
                // 遇到非退格符，退格符数量 -1
                else {
                    sBack--;
                }
                // 指针向前移动
                i--;
            }
            // 统计 t 中当前位置及之前的退格符数量
            while (j >= 0 && (t.charAt(j) == backspace || tBack > 0)) {
                if (t.charAt(j) == backspace) {
                    tBack++;
                } else {
                    tBack--;
                }
                j--;
            }
            // 比较当前位置的字符
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // 如果一个字符串已经遍历完而另一个字符串还没有遍历完，返回 false
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        CompareStringsWithBackspace solution = new CompareStringsWithBackspace();
        String s = "bxj##tw";
        String t = "bxo#j##tw";
        System.out.println(solution.backspaceCompare(s, t));
    }
}
