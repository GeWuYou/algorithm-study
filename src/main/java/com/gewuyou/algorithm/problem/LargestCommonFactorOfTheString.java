package com.gewuyou.algorithm.problem;

/**
 * 1071. 字符串的最大公因子
 *
 * @author gewuyou
 * @since 2024-05-16 下午3:21:32
 */
public class LargestCommonFactorOfTheString {
    public String gcdOfStrings(String str1, String str2) {
        // 如果str1 + str2 不等于 str2 + str1，返回空字符串
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // 计算两个字符串长度的最大公约数
        int gcdLength = gcd(str1.length(), str2.length());

        // 返回str1的前gcdLength个字符
        return str1.substring(0, gcdLength);
        // if (str1.equals(str2)) {
        //     return str1;
        // }
        // int len1 = str1.length();
        // int len2 = str2.length();
        // boolean canSi = false;
        // boolean canS2 = false;
        // if (len1 < len2) {
        //     return gcdOfStrings(str2, str1);
        // }
        // while (len2 > 0) {
        //     while (len1 % len2 != 0) {
        //         len2--;
        //     }
        //     // 重复字符串
        //     StringBuilder repeat = new StringBuilder(str2.substring(0, len2));
        //     String origin = repeat.toString();
        //     while (repeat.length()!=len1) {
        //         if(repeat.length()==str2.length()&&str2.contentEquals(repeat)){
        //             canS2 = true;
        //         }
        //         repeat.append(origin);
        //     }
        //     if (str1.contentEquals(repeat)) {
        //         canSi = true;
        //     }else {
        //         canS2 = false;
        //     }
        //     if (canSi && canS2) {
        //         return origin;
        //     }
        //     len2--;
        // }
        // return "";
    }

    private int gcd(int len1, int len2) {
        return len2==0?len1:gcd(len2,len1%len2);
    }

    public static void main(String[] args) {
        LargestCommonFactorOfTheString solution = new LargestCommonFactorOfTheString();
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String result = solution.gcdOfStrings(str1, str2);
        System.out.println(result);
    }
}
