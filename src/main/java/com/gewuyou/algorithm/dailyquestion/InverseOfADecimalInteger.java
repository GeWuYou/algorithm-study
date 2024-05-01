package com.gewuyou.algorithm.dailyquestion;

/**
 * 1009. 十进制整数的反码
 *
 * @author gewuyou
 * @since 2024-05-13 下午3:02:18
 */
public class InverseOfADecimalInteger {
    public int bitwiseComplement(int n) {
        // int num = 1;
        // // 构造一个长度与num一样位数的但二进制位全部是1的数
        // while ((n & num) != n) {
        //     n = (num << 1) + 1;
        // }
        // // 通过异或操作求出补数
        // return n ^ num;
        String binaryString = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        String reversedBinary = sb.toString();
        int result = 0;
        for (int i = 0; i < reversedBinary.length(); i++) {
            if (reversedBinary.charAt(i) == '1') {
                result += (int) Math.pow(2, reversedBinary.length() - 1 - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InverseOfADecimalInteger inverseOfADecimalInteger = new InverseOfADecimalInteger();
        int n = 10;
        int result = inverseOfADecimalInteger.bitwiseComplement(n);
        System.out.println(result);
    }
}
