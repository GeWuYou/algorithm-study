package com.gewuyou.algorithm.problem;

/**
 * 482. 密钥格式化
 *
 * @author gewuyou
 * @since 2024-04-18 下午3:06:08
 */
public class licenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        // 计算是否有余数
        s=s.replace("-","");
        int remainder = s.length() % k;
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < remainder; i++) {
            sb.append(array[i]);
            if (i == remainder - 1&& i!= array.length - 1) {
                sb.append("-");
            }
        }
        for (int i = remainder; i < array.length; i++) {
            sb.append(array[i]);
            if ((i-remainder) % k == k - 1 && i != array.length - 1) {
                sb.append("-");
            }
        }
        return sb.toString().toUpperCase();
    }
}
