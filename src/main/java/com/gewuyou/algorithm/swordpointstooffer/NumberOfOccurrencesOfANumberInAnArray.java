package com.gewuyou.algorithm.swordpointstooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中数字出现的次数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfOccurrencesOfANumberInAnArray
 * @apiNote </br>
 * @since 2023/2/9 12:53
 */
public class NumberOfOccurrencesOfANumberInAnArray {
    /**
     * 哈希统计法
     *
     * @param nums 数组
     *
     * @return int[]
     * @apiNote (不符合题意)
     * @since 2023/2/9 13:41
     */
    public int[] singleNumbersBak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer result = map.putIfAbsent(num, 1);
            if (result != null) {
                map.put(num, result + 1);
            }
        }
        // 检索只出现一次的数字
        int[] result = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[i++] = entry.getKey();
            }
        }
        return result;
    }

    /**
     * 异或运算
     *
     * @param nums 数组
     * @return int[]
     * @apiNote
     * @since 2023/2/9 13:52
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        int y = 0;
        int n = 0;
        int m = 1;
        for (int num : nums) {
            // 1. 遍历异或 设整型数组nums=[a,a,b,b,...,x,y] ，对nums 中所有数字执行异或，得到的结果为 n = x⊕y
            n ^= num;
        }
        while ((n & m) == 0) {
            // 2. 循环左移，计算 m 判断n上某二进制位为1
            m <<= 1;
        }
        for (int num : nums) {
            // 3. 遍历 nums 分组
            if ((num & m) != 0) {
                // 4. 当 num & m != 0
                x ^= num;
            } else {
                // 4. 当 num & m == 0
                y ^= num;
            }
        }
        // 5. 返回出现一次的数字
        return new int[]{x, y};
    }
    /**
     * 有限状态机
     *
     * @param nums 数组
     *
     * @return int
     * @apiNote
     * @since 2023/2/9 14:14
     */
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
    /**
     * 遍历统计
     *
     * @param nums 数组
     *
     * @return int
     * @apiNote
     * @since 2023/2/9 14:14
     */
    public int singleNumberBak(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                // 更新第 i 位 1 的个数之和
                counts[i] += num & 1;
                // 第 i 位 --> 第 i 位
                num >>= 1;
            }
        }
        int res = 0;
        int m = 3;
        for(int i = 31; i >= 0; i--) {
            res <<= 1;
            // 恢复第 i 位
            res |= counts[i] % m;
        }
        return res;
    }
}
