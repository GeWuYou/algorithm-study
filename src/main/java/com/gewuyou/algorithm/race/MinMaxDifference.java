package com.gewuyou.algorithm.race;

/**
 * 替换一个数字后的最大差值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MinMaxDifference
 * @apiNote </br>
 * @since 2023/2/18 22:32
 */
public class MinMaxDifference {
    public static int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        // 记录头元素
        char head = numStr.charAt(0);
        char flag = head;
        for (int i = 0; i < numStr.length(); i++) {
            if(numStr.charAt(i)!='9'){
                flag = numStr.charAt(i);
                break;
            }
        }
        // 求最大值
        String maxStr=numStr.replace(flag,'9');
        // 求最小值
        String minStr=numStr.replace(head,'0');
        return Integer.parseInt(maxStr)-Integer.parseInt(minStr);
    }
}
