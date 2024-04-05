package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * @author gewuyou
 * @since 2024-04-27 下午3:04:03
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking(String s, List<String> result, ArrayList<String> strings, int index) {
        if (strings.size() == 4 && index >= s.length()) {
            result.add(String.join(".", strings));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String curr = s.substring(index, i + 1);
            // 如果后面三位存在前导为0则跳过
            if (s.charAt(index) == '0' && curr.length() > 1) {
                continue;
            }
            // 如果大于255或者当前位数超过3直接跳过
            if (curr.length() > 3 || Integer.parseInt(curr) > 255) {
                continue;
            }
            strings.add(curr);
            backtracking(s, result, strings, i + 1);
            strings.remove(strings.size() - 1);
        }
    }
}
