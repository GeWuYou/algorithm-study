package com.gewuyou.algorithm.race;

import java.util.*;

/**
 * Q2. 统计好节点的数目
 *
 * @author gewuyou
 * @since 2024-08-11 10:53:24
 */
public class CountTheNumberOfNodes {
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0, -1, g);
        return ans;
    }

    private int ans;

    private int dfs(int x, int fa, List<Integer>[] g) {
        int size = 1;
        int sz0 = 0;
        boolean ok = true;
        for (int y : g[x]) {
            if (y == fa) {
                continue; // 不能递归到父节点
            }
            int sz = dfs(y, x, g);
            if (sz0 == 0) {
                sz0 = sz; // 记录第一个儿子子树的大小
            } else if (sz != sz0) {
                ok = false; // 注意后面的子树 y 仍然要递归计算 ans
            }
            size += sz;
        }
        if (ok) {
            ans++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{0,5},{1,6},{2,7},{3,8}};
        CountTheNumberOfNodes solution = new CountTheNumberOfNodes();
        int result = solution.countGoodNodes(edges);
        System.out.println(result);
    }
}
