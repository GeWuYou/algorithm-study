package com.gewuyou.algorithm.dailyquestion;

/**
 * 柠檬水找零
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/22 9:13
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }else if (bill == 10 && five > 0) {
                five--;
                ten++;
            } else if(five==0) {
                return false;
            } else if (five > 0 && ten > 0) {
				five--;
                ten--;
            } else if (five >= 3) {
				five-=3;
            }else {
                return false;
            }
        }
        return true;
    }
}
