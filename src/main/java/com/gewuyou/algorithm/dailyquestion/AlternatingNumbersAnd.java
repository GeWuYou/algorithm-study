package com.gewuyou.algorithm.dailyquestion;

/**
 * 交替数字和
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/12 8:15
 */
public class AlternatingNumbersAnd {
    public int alternateDigitSum(int n) {
        int sum = 0;
        char[] array = String.valueOf(n).toCharArray();
        for (int i = 0; i < array.length; i++) {
            if((i&1)==1){
                sum-=array[i]-'0';
            }else{
                sum+=array[i]-'0';
            }
        }
        return sum;
    }
}
