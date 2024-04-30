package com.gewuyou.algorithm.problem;

/**
 * 二进制求和
 *
 * @author gewuyou
 * @since 2024-04-05 下午3:12:10
 */
public class AddBinary {


    public String addBinary(String a, String b) {
        String baseString = "0";
        int difference = a.length() - b.length();
        StringBuilder result = new StringBuilder();
        if (difference > 0) {
            b = baseString.repeat(difference) + b;
        } else if (difference < 0) {
            a = baseString.repeat(Math.abs(difference)) + a;
        }
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int temp = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            if (temp > 1) {
                temp = temp - 2;
                carry = 1;
            } else {
                carry = 0;
            }
           result.append(temp);
        }
        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

}
