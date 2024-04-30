package com.gewuyou.algorithm.dailyquestion;

/**
 * 统计星号
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName StatisticsAsterisk
 * @apiNote </br>
 * @since 2023/1/29 12:10
 */
public class StatisticsAsterisk {
    public int countAsterisks(String s) {
        // 创建一个星号计数器
        int count = 0;
        // 创建一个标记记录符号状态，在符号内为true反之为false
        boolean isSymbol = false;
        for (int i = 0; i < s.length(); i++) {
            // 如果当前字符为|，将其加入到栈中
            if(s.charAt(i) == '|'){
                // 对状态取反
                isSymbol =!isSymbol;
            }
            // 如果当前字符为*号
            else if (s.charAt(i) == '*'&&!isSymbol) {
                count++;
            }
        }
        return count;
    }
}
