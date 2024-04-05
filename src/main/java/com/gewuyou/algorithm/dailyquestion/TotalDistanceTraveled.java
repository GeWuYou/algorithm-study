package com.gewuyou.algorithm.dailyquestion;

/**
 * 2739. 总行驶距离
 *
 * @author gewuyou
 * @since 2024-04-25 下午1:09:25
 */
public class TotalDistanceTraveled {
    public int distanceTraveled(int mainTank, int additionalTank) {
        // int result = 0;
        // while (mainTank > 0) {
        //     if (mainTank >= 5) {
        //         result += 50;
        //         if (additionalTank > 0) {
        //             mainTank -= 4;
        //             additionalTank--;
        //         } else {
        //             mainTank -= 5;
        //         }
        //     } else {
        //         result += mainTank * 10;
        //         mainTank = 0;
        //     }
        // }
        // return result;
        int result = 0;
        while (mainTank >= 5) {
            mainTank -= 5;
            result += 50;
            if (additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }
        }
        return result + mainTank * 10;
    }
}
