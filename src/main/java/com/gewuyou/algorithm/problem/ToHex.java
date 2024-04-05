package com.gewuyou.algorithm.problem;

/**
 * 405. 数字转换为十六进制数
 *
 * @author gewuyou
 * @since 2024-04-15 下午2:42:07
 */
public class ToHex {
    public String toHex(int num) {
        // 特殊情况处理
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num!= 0) {
            // 通过与运算获取最低四位十六进制数 num & 0xf = num & 1111
            int hex = num & 0xf;
            // 转换为对应的十六进制字符
            if (hex < 10) {
                sb.append((char) (hex + '0'));
            } else {
                sb.append((char) (hex - 10 + 'a'));
            }
            // 右移四位
            num = num >>> 4;
        }
        // 反转字符串
        return sb.reverse().toString();
    }
}
