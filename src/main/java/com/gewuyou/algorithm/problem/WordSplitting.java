package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 * @author gewuyou
 * @since 2024-05-10 下午6:55:22
 */
public class WordSplitting {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典列表转换为集合，加快查找速度
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        // 空字符串可以被任意单词拼接而成
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // / 更新 dp[i] 为 true，
                    // 表示字符串 s 的前 i 个字符可以被字典中的单词拼接而成
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
