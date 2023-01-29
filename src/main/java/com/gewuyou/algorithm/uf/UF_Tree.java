package com.gewuyou.algorithm.uf;

/**
 * 并查集
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName UF_Tree
 * @apiNote 并查集 使用树进行优化查询
 * @since 2022/9/7 8:56
 */
public class UF_Tree {
    /**
     * 记录节点元素和该元素所在分组
     */
    private int[] elementAndGroup;

    /**
     * 记录并查集中的数据的分组个数
     */
    private int count;

    public UF_Tree(int count) {
        // 初始化分组的数量，默认情况下有count个分组
        this.count = count;
        // 初始化elementAndGroup数组
        this.elementAndGroup = new int[count];
        // 初始化elementAndGroup数组中的元素及所在组的标识符
        // 默认情况下让该数组的索引作为并查集的每个节点的元素，让数组的元素作为该并查集的元素所在的组的父节点
        for (int i = 0; i < elementAndGroup.length; i++) {
            elementAndGroup[i] = i;
        }
    }


    /**
     * 获取分组
     *
     * @return int
     * @apiNote 获取当前并查集有多少个分组
     * @since 2022/9/7 8:59
     */
    public int count() {
        return count;
    }

    /**
     * 查询表示符
     *
     * @param p 要查询的元素
     * @return int
     * @apiNote 查询元素p所在的分组标识
     * @since 2022/9/7 9:02
     */
    private int findGroup(int p) {
        while (true) {
            if (elementAndGroup[p] == p) {
                return p;
            }
            p = elementAndGroup[p];
        }
    }

    /**
     * 判断同一分组
     *
     * @param p 元素p
     * @param q 元素q
     * @return boolean
     * @apiNote 判断并查集中元素p与元素q是否在同一分组中
     * @since 2022/9/7 9:04
     */
    public boolean connected(int p, int q) {
        return findGroup(p) == findGroup(q);
    }

    /**
     * 合并分组
     *
     * @param p 元素p
     * @param q 元素q
     * @apiNote 把p元素所在分组和元素q所在的分组合并
     * @since 2022/9/7 9:21
     */
    public void union(int p, int q) {
        // 找到p元素和q元素所在组对应的树的根节点
        int pRoot = findGroup(p);
        int qRoot = findGroup(q);
        // 如果二者根节点相同则不需要合并了
        if (qRoot == pRoot) {
            return;
        }
        // 让p所在的树的根节点的父节点等于q所在的根节点
        elementAndGroup[pRoot] = elementAndGroup[qRoot];
        // 组数量减一
        count--;
    }
}
