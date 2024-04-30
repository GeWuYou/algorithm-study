package com.gewuyou.algorithm.problem;

/**
 * 72. 编辑距离
 *
 * @author gewuyou
 * @since 2024-04-20 上午9:57:05
 */
public class EditTheDistance {
    public int minDistance(String word1, String word2) {
        // 创建二维数组 dp dp[i][j] 表示 word1 的前 i 个字符和 word2 的前 j 个字符的编辑距离，
        // 即前者的第i个字符转换为后者第j个字符所需的最少操作次数
        int n = word1.length();
        int k = word2.length();
        int[][] dp = new int[n + 1][k + 1];
        /*
          定义状态转移方程：
            如果word1的第i-1个字符和word2的第j-1个字符相同则不需要操作，dp[i][j] = dp[i-1][j-1]
            如果 word1[i-1] 不等于 word2[j-1]，则可以进行三种操作：
                插入操作：在 word1 的第 i 个位置插入一个字符，使其与 word2 的第 j 个字符相等，此时需要考虑 dp[i][j-1]；
                删除操作：删除 word1 的第 i 个字符，使得 word1 的前 i-1 个字符与 word2 的前 j 个字符相等，此时需要考虑 dp[i-1][j]；
                替换操作：将 word1 的第 i 个字符替换为 word2 的第 j 个字符，此时需要考虑 dp[i-1][j-1]。
            得出状态转移方程为：
                dp[i][j] =
                    if word1[i-1] == word2[j-1]:
                        dp[i-1][j-1]
                    else:
                        min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
         */
        // 初始化边界条件
        /*
         * 接着，我们初始化边界条件，即当 i=0 或 j=0 时，dp[i][j] 的值，表示空字符串与对应子串之间的编辑距离。
         * 具体来说，dp[i][0] 表示将一个字符串转换为空串的编辑距离，等于 i；
         * 同理，dp[0][j] 表示将一个空串转换为另一个字符串的编辑距离，等于 j。
         * */
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= k; j++) {
            dp[0][j] = j;
        }
        // 填充二维数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        EditTheDistance editTheDistance = new EditTheDistance();
        String word1 = "horse";
        String word2 = "ros";

        int distance = editTheDistance.minDistance(word1, word2);
        System.out.println(distance); // 3
    }
}
