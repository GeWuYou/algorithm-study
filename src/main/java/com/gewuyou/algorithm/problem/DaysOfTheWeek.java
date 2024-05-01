package com.gewuyou.algorithm.problem;

import java.time.LocalDateTime;

/**
 * 1185. 一周中的第几天
 *
 * @author gewuyou
 * @since 2024-05-19 上午9:53:51
 */
public class DaysOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        // String weekStr = LocalDateTime.of(year, month, day, 0, 0, 0).getDayOfWeek().toString();
        // return weekStr.charAt(0)+weekStr.substring(1).toLowerCase();
        // 19700-01-01是周四 索引为3+day 3指的是数组中对应的星期为星期三
        int a = 3 + day;
        String[] arr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // 遍历年份
        for (int i = 1970; i < year; i++) {
            // 平年365天，闰年366天
            a += 365;
            if (leap(i)) {
                a++;
            }
        }
        // 遍历月份
        int[] m = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        // 闰年2月有29天
        if (leap(year)) {
            m[1]++;
        }
        // 遍历日
        for (int i = 0; i < month - 1; i++) {
            a += m[i];
        }
        // 返回对应星期 通过计算从1970-01-01到指定日期的天数，再加上指定日期的索引并取模，得到对应星期的索引，再从数组中取出对应的星期
        return arr[a % 7];
    }

    /**
     * 判断是否为闰年
     *
     * @param year 年份
     * @return boolean 是否为闰年
     * @apiNote 判断是否为闰年的方法：<p/>
     * 1. 能被4整除但不能被100整除的年份为闰年。<p/>
     * 2. 能被400整除的年份为闰年。<p/>
     * 3. 其他年份不是闰年。
     * @since 2024/5/19 上午10:15
     */
    private boolean leap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }


    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.of(2024, 5, 19, 0, 0, 0);
        System.out.println(now.getDayOfWeek().name());
    }
}
