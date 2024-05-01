package com.gewuyou.algorithm.problem;

/**
 * 1323. 6 和 9 组成的最大数字
 *
 * @author gewuyou
 * @since 2024-05-23 下午3:52:52
 */
public class MaximumNumberMadeUpOf6And9 {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        int index = str.indexOf('6');
        if(index!= -1){
            char[] array = str.toCharArray();
            array[index] = '9';
            return Integer.parseInt(new String(array));
        }
        return Integer.parseInt(str);
    }
}