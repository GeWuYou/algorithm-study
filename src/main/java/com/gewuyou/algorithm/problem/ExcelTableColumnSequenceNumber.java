package com.gewuyou.algorithm.problem;

/**
 * Excel 表列序号
 *
 * @author gewuyou
 * @since 2024-04-07 下午1:08:36
 */
public class ExcelTableColumnSequenceNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int length = columnTitle.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            int num = c - 'A' + 1;
            result += (int) (num * Math.pow(26, length - 1.0 - i));
        }
        return result;
    }
}
