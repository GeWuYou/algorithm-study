package com.gewuyou.algorithm.problem;

/**
 * 806. 写字符串需要的行数
 *
 * @author gewuyou
 * @since 2024-05-02 下午2:29:53
 */
public class NumberOfLinesRequiredToWriteTheString {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int width = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int w = widths[c - 'a'];
            if (width + w > 100) {
                line++;
            }
            width = (width + w > 100)? w : width + w;
        }
        return new int[]{line, width};
    }
}
