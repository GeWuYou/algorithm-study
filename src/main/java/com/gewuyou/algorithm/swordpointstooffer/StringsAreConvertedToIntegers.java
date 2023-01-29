package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 把字符串转换成整数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName StringsAreConvertedToIntegers
 * @apiNote </br>
 * @since 2023/2/22 17:28
 */
public class StringsAreConvertedToIntegers {
    public static int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        // 是否为正
        boolean mark = true;
        // 判断字符串为空与空串
        if (length == 0) {
            return 0;
        }
        int index = 0;
        // 跳过前置空格串
        while (str.charAt(index) == ' ') {
            index++;
            if (index == length) {
                return 0;
            }
        }
        // 判断符号
        if (str.charAt(index) == '-') {
            mark = false;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        int result = 0;
        // 判断字符串中第一个非空格字符不是一个有效的整型字符
        for (int i = index; i < length; i++) {
            int temp = str.charAt(i) - '0';
            // 判断是否不为数字
            if (temp > 9 || temp < 0) {
                break;
            }
            // 判断是否越界
            if (result > Integer.MAX_VALUE / 10 || ((result == Integer.MAX_VALUE / 10) && temp >= 8)) {
                return mark ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
        }
        return mark ? result : -result;
    }
}
