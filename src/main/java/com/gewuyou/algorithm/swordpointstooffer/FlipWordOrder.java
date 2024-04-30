package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 翻转单词顺序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FlipWordOrder
 * @apiNote </br>
 * @since 2023/1/31 9:39
 */
public class FlipWordOrder {
    public String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        // 计算字符串长度
        int length = s.length();
        // 定义双指针
        int staticPointer = length - 1;
        int dynamicPointer = length - 1;
        // 倒序遍历字符串
        StringBuilder result = new StringBuilder();
        while (dynamicPointer >= 0) {
            // 寻找第一个单词
            while (dynamicPointer >= 0 && s.charAt(dynamicPointer) != ' ') {
                dynamicPointer--;
            }
            // 将第一个单词加入
            result.append(s, dynamicPointer + 1, staticPointer + 1).append(" ");
            // 跳过单词间空格
            while (dynamicPointer >= 0 && s.charAt(dynamicPointer) == ' ') {
                dynamicPointer--;
            }
            // 移动静态指针
            staticPointer = dynamicPointer;
        }
        // 返回结果
        return result.toString().trim();
    }
}
