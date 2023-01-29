package com.gewuyou.algorithm.dailyquestion;

/**
 * 字符串相加
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/17 10:19
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; carry > 0 || i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addStrings("123456789", "987654321");
    }
}
