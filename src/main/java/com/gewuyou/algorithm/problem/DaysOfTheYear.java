package com.gewuyou.algorithm.problem;

/**
 * 1154. 一年中的第几天
 *
 * @author gewuyou
 * @since 2024-05-18 下午2:02:43
 */
public class DaysOfTheYear {
    public int dayOfYear(String date) {
        // 解析字符串
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        // 计算天数
        int days = 0;
        for (int i = 1; i < month; i++) {
            days += daysOfMonth(i, year);
        }
        days += day;
        return days;
    }

    private int daysOfMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    return 29;
                }else {
                    return 28;
                }
        }
        return 30;
    }

    public static void main(String[] args) {

        DaysOfTheYear daysOfTheYear = new DaysOfTheYear();
        int dayOfYear = daysOfTheYear.dayOfYear("2003-03-01");
        System.out.println(dayOfYear);
    }
}