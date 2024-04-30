package com.gewuyou.algorithm.problem;

/**
 * 717. 1 比特与 2 比特字符
 *
 * @author gewuyou
 * @since 2024-04-30 上午8:14:20
 */
public class _1BitVs2BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        // 首先判断最后一位是否为 1
        if (bits[n - 1] == 1) {
            return false;
        }
        // 计算 连续1的个数
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                count++;
            }else {
                break;
            }
        }

        // 如果连续1的个数为偶数，则为 1 比特字符
        return (count&1)==0;
    }
}
