package com.gewuyou.algorithm.problem;

/**
 * 551. 学生出勤记录 I
 *
 * @author gewuyou
 * @since 2024-04-22 下午1:10:04
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        char[] array = s.toCharArray();

        int countA = 0;
        int countL = 0;
        for (char c : array) {
            if (c == 'A') {
                countL = 0;
                countA++;
                if (countA >= 2) {
                    return false;
                }
                continue;
            }
            if (c == 'L') {
                countL++;
                if (countL > 2) {
                    return false;
                }
            } else {
                countL = 0;
            }
        }
        return true;
    }
}
