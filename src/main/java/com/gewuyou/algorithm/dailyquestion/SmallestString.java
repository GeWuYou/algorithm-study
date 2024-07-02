package com.gewuyou.algorithm.dailyquestion;

/**
 * 3106. 满足距离约束且字典序最小的字符串
 *
 * @author gewuyou
 * @since 2024-07-27 上午8:19:43
 */
public class SmallestString {
    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (k == 0 || c == 'a') {
                sb.append(c);
                continue;
            }
            int cost1 =  c - 'a';
            int cost2 = Math.abs(c - 'z') + 1;
            boolean canChange1 = cost1 <= k;
            boolean canChange2 = cost2 <= k;
            if(canChange1 && canChange2) {
                if(cost1 < cost2) {
                    k -= cost1;
                    sb.append('a');
                }else {
                    k -= cost2;
                    sb.append('a');
                }
                continue;
            }
            // 判断是否可以修改为a
            if (canChange1) {
                k -= cost1;
                sb.append('a');
            } else if (canChange2) {
                k -= cost2;
                sb.append('a');
            } else {
                sb.append((char) (c - k));
                k = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestString solution = new SmallestString();
        String s = "vczp";
        int k = 48;
        String result = solution.getSmallestString(s, k);
        System.out.println(result);
    }
}
