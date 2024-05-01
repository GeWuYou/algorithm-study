package com.gewuyou.algorithm.problem;

/**
 * 942. 增减字符串匹配
 *
 * @author gewuyou
 * @since 2024-05-10 下午2:16:14
 */
public class AddOrSubtractStringMatching {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n+1];
        int i = 0;
        int d = n;
        for (int j = 0; j < n; j++) {
            char charAt = s.charAt(j);
            // perm[j] < perm[j + 1]
            if (charAt == 'I') {
                result[j] = i++;
            }
            // perm[j] > perm[j + 1]
            else
            // D
            {
             result[j] = d--;
            }
        }
        result[n] = i;
        return result;
    }
}
