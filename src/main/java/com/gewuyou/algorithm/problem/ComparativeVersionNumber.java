package com.gewuyou.algorithm.problem;

/**
 * 比较版本号
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ComparativeVersionNumber
 * @apiNote </br>
 * @since 2022/12/29 11:38
 */
public class ComparativeVersionNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare(String version1, String version2) {
        // 健壮性
        if (version1 == null && version2 == null) {
            return 0;
        }
        // 切割字符串
        String[] number1 = version1.split("\\.");
        String[] number2 = version2.split("\\.");
        // 求出两个切割数组中的最大长度
        int length = Math.max(number1.length, number2.length);
        // 遍历切割数组
        for (int i = 0; i < length; i++) {
            // 1.1与1.11转换后为11与111，需要添加0
            String string1 = i < number1.length ? number1[i] : "0";
            String string2 = i < number2.length ? number2[i] : "0";

            // 剔除切割字符串中的0
            for (int j = 0; j < string1.length(); j++) {
                if (j == string1.length() - 1 || string1.charAt(j) != '0') {
                    string1 = string1.substring(j);
                    break;
                }
            }
            for (int k = 0; k < string2.length(); k++) {
                if (k == string2.length() - 1 || string2.charAt(k) != '0') {
                    string2 = string2.substring(k);
                    break;
                }
            }
            if (string1.length() > string2.length()) {
                return 1;
            } else if (string1.length() < string2.length()) {
                return -1;
            } else {
                if (string1.compareTo(string2) > 0) {
                    return 1;
                } else if (string1.compareTo(string2) < 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
