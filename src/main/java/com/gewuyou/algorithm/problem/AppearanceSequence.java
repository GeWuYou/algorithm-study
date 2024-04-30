package com.gewuyou.algorithm.problem;

/**
 * 38. 外观数列
 *
 * @author gewuyou
 * @since 2024-04-12 下午5:12:51
 */
public class AppearanceSequence {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        if (n == 1) {
            return sb.toString();
        }
        for (int i = 2; i < n + 1; i++) {
            // 解释外观数列
            StringBuilder temp = new StringBuilder();
            String s = sb.toString();
            char[] charArray = s.toCharArray();
            char curr = 0;
            int count = 0;
            int j = 0;
            while (j < charArray.length) {
                if (j == 0) {
                    curr = charArray[j];
                    count++;
                    j++;
                    continue;
                }
                if (curr == charArray[j]) {
                    count++;
                    j++;
                } else {
                    temp.append(count).append(curr);
                    count = 0;
                    curr = charArray[j];
                }
            }
            if (count != 0) {
                temp.append(count).append(curr);
            }
            sb = temp;
        }
        return sb.toString();
    }
}
