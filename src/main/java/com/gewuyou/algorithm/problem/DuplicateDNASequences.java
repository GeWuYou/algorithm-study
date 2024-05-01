package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. 重复的DNA序列
 *
 * @author gewuyou
 * @since 2024-05-18 下午3:02:12
 */
public class DuplicateDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n <= 10) {
            return new ArrayList<>();
        }
        // 记录所有序列
        Set<String> seen = new HashSet<>();
        // 记录重复序列
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            // 如果该序列出现过则加入重复序列
            if (seen.contains(sub)) {
                repeated.add(sub);
            }
            // 否则加入已出现过的序列
            else {
                seen.add(sub);
            }
        }
        return new ArrayList<>(repeated);
    }

}

