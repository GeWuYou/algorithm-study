package com.gewuyou.algorithm.dailyquestion;

/**
 * 泰波那契数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/27 21:47
 */
public class Tribonacci {
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 3; i <= n; i++) {
            int temp = first+second+third;
            first = second;
            second = third;
            third = temp;
        }
        return third;
    }
}
