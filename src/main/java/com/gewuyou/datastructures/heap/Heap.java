package com.gewuyou.datastructures.heap;

/**
 * 堆
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Heap
 * @apiNote 堆
 * @since 2022/9/2 12:26
 */
public class Heap<T extends Comparable<T>> {
    /**
     * 储存堆中的元素
     */
    private T[] datas;

    /**
     * 记录堆中元素的个数
     */
    private int count;

    public Heap(int capacity) {
        //初始化数据数组 因为废弃掉了0、所以容量需要加一 此处不能用object类型 java.lang.Object; cannot be cast to java.lang.Comparable
        this.datas = (T[]) new Comparable[capacity+1];
        //初始化个数
        this.count = 0;
    }

    /**
     * 元素比较方法
     *
     * @param i
     * @param j
     * @return boolean
     * @apiNote 判断堆中索引处i的元素是否小于索引j处的元素
     * @since 2022/9/2 13:07
     */
    private boolean less(int i, int j) {
        return datas[i].compareTo(datas[j]) < 0;
    }

    /**
     * 元素交换
     *
     * @param i
     * @param j
     * @apiNote 交换堆中i索引与j索引处的值
     * @since 2022/9/2 13:09
     */
    private void exch(int i, int j) {
        T temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    /**
     * 插入元素
     *
     * @param t 元素
     * @apiNote 往堆中插入一个元素
     * @since 2022/9/2 13:11
     */
    public void insert(T t) {
        // 初次插入时会抛弃索引0，方便使用
        datas[++count] = t;
        swim(count);
    }

    /**
     * 上浮大元素
     *
     * @param index 索引
     * @apiNote 使用上浮算法，使索引index处的元素能在堆中处于一个合适的位置
     * @since 2022/9/2 13:12
     */
    private void swim(int index) {

        // 通过循环不断比较当前节点的值和其父节点的值，如果发现父节点的值比当前节点值小，则交换位置
        while (index > 1) {
            // 比较当前节点的值和其父节点的值
            if (less(index / 2, index)) {
                exch(index / 2, index);
                index /= 2;
            }
        }
    }

    /**
     * 下沉元素
     *
     * @param index 索引
     * @apiNote 使用下沉算法，使索引index处的元素能够在堆中处于一个正确的位置
     * @since 2022/9/2 13:19
     */
    private void sink(int index) {
        //通过循环不断的对比当前节点和其左子节点2*k和右子节点2*k+1中的较大值节点
        int maxIndex;
        while (2 * index <= count) {
            // 判断是否有右子节点
            if (2 * index + 1 <= count) {
                // 获取当前节点的子节点中的较大节点
                maxIndex = less(2 * index, 2 * index + 1) ?  2 * index + 1: 2 * index;
            } else {
                // 如果没有右节点，默认左边节点为最大的节点
                maxIndex = 2 * index;
            }
            // 比较当前接单与其子节点中较大节点的值
            if (!less(index, maxIndex)) {
                // 当前节点值比较大子节点要大，没有必要比较了，直接返回
                return;
            } else {
                // 当前节点值比较大子节点要小，交换当前节点与较大子节点的值
                exch(index, maxIndex);
                // 变换索引值 为下一循环作准备
                index = maxIndex;
            }
        }
    }

    /**
     * 删除最大值
     *
     * @return T 最大值
     * @apiNote 删除堆中最大的元素，并返回该元素
     * @since 2022/9/2 13:15
     */
    public T deleteMax() {
        // 在堆中根节点的值为最大值
        T max = datas[1];
        // 交换1索引处与最大索引处的值，让完全二叉树中最右侧是元素变为临时根节点
        exch(1, count);
        // 删除最大索引处的元素
        datas[count] = null;
        // 元素个数减一
        count--;
        // 通过下沉算法调整堆结构，让堆重新有序
        sink(1);
        return max;
    }


}
