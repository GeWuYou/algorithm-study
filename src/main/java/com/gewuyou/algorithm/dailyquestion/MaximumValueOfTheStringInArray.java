package com.gewuyou.algorithm.dailyquestion;

/**
 * 数组中字符串的最大值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/23 10:45
 */
public class MaximumValueOfTheStringInArray {
    public int maximumValue(String[] strs) {
        int result = 0;
        boolean isPureNumber;
        // 遍历字符串
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            isPureNumber = true;
            for (char c : strs[i].toCharArray()) {
                if(c>='a'&&c<='z') {
                    result = Math.max(result,strs[i].length());
                    isPureNumber = false;
                    break;
                }
            }
            // 判断是否为纯数字
            if(isPureNumber){
                result = Math.max(result,Integer.parseInt(strs[i]));
            }
        }
        return result;
    }
}
