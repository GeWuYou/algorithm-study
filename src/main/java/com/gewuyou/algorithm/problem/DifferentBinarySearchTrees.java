package com.gewuyou.algorithm.problem;

/**
 * 96. 不同的二叉搜索树
 *
 * @author gewuyou
 * @since 2024-04-28 下午8:36:02
 */
public class DifferentBinarySearchTrees {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        // 当 n = 0 时，只有一种树，即空树
        G[0] = 1;
        // 当 n = 1 时，只有一种树，即根节点
        G[1] = 1;

        // 递推公式：G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1)*G(0)
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
