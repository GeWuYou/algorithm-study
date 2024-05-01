package com.gewuyou.algorithm.problem;

/**
 * 1309. 解码字母到整数映射
 *
 * @author gewuyou
 * @since 2024-05-23 下午2:23:42
 */
public class DecodeLetterToIntegerMappings {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int n = s.length();
        for (int length = n - 1; length >= 0; length--) {
            temp.setLength(0);
            // 表明后两位编码数字
            if (s.charAt(length) == '#') {
                int count = 1;
                while (count<3&&s.charAt(length-count)!= '#'){
                    temp.append(s.charAt(length-count));
                    count++;
                }
                char c = (char) (Integer.parseInt(temp.reverse().toString()) + 'a' - 1);
                sb.append(c);
                length -= 2;
            } else {
                // 单个数字编码字符
                char c = (char) (s.charAt(length) - '0' + 'a' - 1);
                sb.append(c);
            }
        }
        return sb.reverse().toString();
        // StringBuilder sb = new StringBuilder();
        // int i = 0;
        // while (i < s.length()) {
        //     if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
        //         // 两位数编码字符
        //         String numStr = s.substring(i, i + 2);
        //         int num = Integer.parseInt(numStr);
        //         sb.append((char) (num + 'a' - 1));
        //         i += 3; // 跳过两位数字和一个 '#'
        //     } else {
        //         // 单个数字编码字符
        //         int num = s.charAt(i) - '0';
        //         sb.append((char) (num + 'a' - 1));
        //         i++;
        //     }
        // }
        // return sb.toString();
    }

    public static void main(String[] args) {
        DecodeLetterToIntegerMappings d = new DecodeLetterToIntegerMappings();
        String s = "151112";
        System.out.println(d.freqAlphabets(s));
    }
}
