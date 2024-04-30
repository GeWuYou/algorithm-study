package com.gewuyou.algorithm.dailyquestion;

/**
 * 检查替换后的词是否有效
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CheckThatTheReplacedWordIsValid
 * @apiNote </br>
 * @since 2023/5/3 15:23
 */
public class CheckThatTheReplacedWordIsValid {
    public boolean isValid(String s) {
        // 创建字符栈
        StringBuilder sb = new StringBuilder();
        // 遍历字符串，将遍历到的字符压入栈中
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            // 当长度大于等于3时判断栈顶的三个元素是否为abc
            if (sb.length() >= 3 && "abc".equals(sb.substring(sb.length() - 3, sb.length()))) {
                // 删除这三个元素
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        return sb.length() == 0;
    }
}
