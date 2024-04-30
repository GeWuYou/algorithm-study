package com.gewuyou.algorithm.dailyquestion;

/**
 * 公因子的数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfCommonFactors
 * @apiNote </br>
 * @since 2023/4/5 13:22
 */
public class NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int result = 0;
        for(int i = 1;i<=Math.min(a,b);i++){
            if(a%i==0&&b%i==0){
                result++;
            }
        }
        return result;
    }
}
