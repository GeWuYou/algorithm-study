package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 2007. 从双倍数组中还原原数组
 *
 * @author gewuyou
 * @since 2024-04-18 下午12:45:39
 */
public class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        if ((changed.length & 1) == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        int[] ans = new int[changed.length / 2];
        int ansIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : changed) {
            // i 不是双倍后的元素
            if (!map.containsKey(i)) {
                if (ansIndex == ans.length) {
                    return new int[0];
                }
                ans[ansIndex++] = i;
                map.merge(i * 2, 1, Integer::sum);
            } else {
                // 清除标记
                int count = map.merge(i, -1, Integer::sum);

                if (count == 0) {
                    map.remove(i);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        FindOriginalArray solution = new FindOriginalArray();
        int[] changed = {6,3,0,1};
        for (int i = 0; i < solution.findOriginalArray(changed).length; i++) {
            System.out.print(solution.findOriginalArray(changed)[i] + " ");
        }
    }
}
