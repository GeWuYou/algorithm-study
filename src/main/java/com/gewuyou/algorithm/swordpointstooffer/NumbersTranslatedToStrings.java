package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 数字翻译成字符串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumbersTranslatedToStrings
 * @apiNote </br>
 * @since 2023/1/28 11:23
 */
public class NumbersTranslatedToStrings {
    public int translateNum(int num) {
        // 设置指针
        int pre = 1;
        int next = 1;

        int before;
        int after = num % 10;
        // 当循环执行到个位时结束
        while (num > 9) {
            // 数字退位
            num /= 10;
            // 移动指针
            before = num % 10;
            // 拼出比较数字
            int temp = before * 10 + after;
            // 判断当前数字是否存在两种情况
            int result = (temp >= 10 && temp <= 25) ? pre + next : pre;
            // 移动指针
            next = pre;
            pre = result;
            after = before;
        }
        return pre;
    }
}
