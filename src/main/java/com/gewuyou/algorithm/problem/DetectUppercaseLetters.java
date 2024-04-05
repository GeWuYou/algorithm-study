package com.gewuyou.algorithm.problem;

/**
 * 520. 检测大写字母
 *
 * @author gewuyou
 * @since 2024-04-20 上午9:30:31
 */
public class DetectUppercaseLetters {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        char[] array = word.toCharArray();
        // 首字母是否大写
        boolean isFirstUpper = false;
        // 后续字母是否大写
        boolean isSubsequentUpper = false;
        // 是否存在小写字母
        boolean isExistenceLower = false;
        for (int i = 0; i < n; i++) {
            // 如果当前字母是大写
            if (array[i] >= 'A' && array[i] <= 'Z') {
                // 首字母大写
                if (i == 0) {
                    isFirstUpper = true;
                }
                // 后续字母大写
                else {
                    // 如果后续字母大写但存在字母小写，则不合法
                    if (isExistenceLower) {
                        return false;
                    }
                    isSubsequentUpper = true;
                }
            }
            // 如果当前字母是小写
            else if (array[i] >= 'a' && array[i] <= 'z') {
                isExistenceLower = true;
                // 如果首字母状态是大写，后续字母状态大写，当前字母小写则不合法
                if (isFirstUpper && isSubsequentUpper) {
                    return false;
                }
            }
        }
        return true;
    }
}
