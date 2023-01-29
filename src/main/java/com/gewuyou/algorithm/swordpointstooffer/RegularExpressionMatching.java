package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 正则表达式匹配
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RegularExpressionMatching
 * @apiNote </br>
 * @since 2023/3/8 12:45
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        // 创建动态规划矩阵
        boolean[][] dp = new boolean[m][n];
        // 代表空字符状态 代表两个空字符串能够匹配
        dp[0][0] = true;
        for (int i = 2; i < n; i += 2) {
            // dp[0][i - 2] && p.charAt(i - 1) == '*' 首行s为空串，因此当p的偶数为为*时才能够匹配(即让p的奇数位出现0次，保持p是空串)
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                        dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[m - 1][n - 1];
    }
}
