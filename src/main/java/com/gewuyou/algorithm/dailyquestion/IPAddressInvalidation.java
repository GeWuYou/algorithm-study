package com.gewuyou.algorithm.dailyquestion;

/**
 * 1108. IP 地址无效化
 *
 * @author gewuyou
 * @since 2024-05-17 下午5:43:07
 */
public class IPAddressInvalidation {
    public String defangIPaddr(String address) {
        String[] strings = address.split("\\.");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i!= strings.length - 1) {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}
