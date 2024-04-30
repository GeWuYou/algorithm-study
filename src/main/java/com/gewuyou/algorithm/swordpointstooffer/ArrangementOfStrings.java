package com.gewuyou.algorithm.swordpointstooffer;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 字符串的排列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ArrangementOfStrings
 * @apiNote </br>
 * @since 2023/2/28 19:32
 */
public class ArrangementOfStrings {
    public String[] permutation(String s) {
        // 创建临时集合
        Set<String> temp = new LinkedHashSet<>();
        // 切割字符串
        char[] chars = s.toCharArray();
        // 进行方法递归
        recursion(temp, chars, 0);
        return temp.toArray(new String[chars.length]);
    }

    private void recursion(Set<String> temp, char[] chars, int index) {
        // 如果索引还没结束则继续递归
        if (index < chars.length) {
            // 遍历当前组合
            for (int i = index; i < chars.length; i++) {
                // 交换二者
                exchange(chars, i, index);
                //递归调用方法
                recursion(temp, chars, index + 1);
                // 将二者换回
                exchange(chars, i, index);
            }
        }
        // 当索引到达边界时将结果加入集合
        else {
            temp.add(String.valueOf(chars));
        }
    }

    private void exchange(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
