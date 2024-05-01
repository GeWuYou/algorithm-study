package com.gewuyou.algorithm.problem;

/**
 * 137. 只出现一次的数字 II
 *
 * @author gewuyou
 * @since 2024-05-09 下午3:56:19
 */
public class NumberIIAppearsOnlyOnce {
    public int singleNumber(int[] nums) {
        // Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        // for (int num : nums) {
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }
        // int ans = 0;
        // for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        //     int num = entry.getKey(), occ = entry.getValue();
        //     if (occ == 1) {
        //         ans = num;
        //         break;
        //     }
        // }
        // return ans;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // 统计第i位上的1的个数
                count += (num >> i) & 1;

            }
            // 如果第 i 位上 1 的个数不是 3 的倍数，则说明只出现一次的数字在该位上是 1
            if (count % 3 != 0) {
                // 将该位上的 1 置为 0，其他位上的 1 保持不变
                ans |= (1 << i);
            }
        }
        return ans;
    }
}