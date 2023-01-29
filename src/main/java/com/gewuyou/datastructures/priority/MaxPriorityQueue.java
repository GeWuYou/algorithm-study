package com.gewuyou.datastructures.priority;

/**
 * 最大优先队列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaxPriorityQueue
 * @apiNote 最大优先队列(基于堆)
 * @since 2022/9/3 14:08
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

    /**
     * 储存堆中元素
     */
    private T[] items;

    /**
     * 记录堆中要元素个数
     */
    private int count;

    public MaxPriorityQueue(int capacity) {
        // ! 注意由于堆中不在0索引处存放值，所以新数组长度须加一，所以使用length时要注意减一长度
        this.items = (T[]) new Comparable[capacity + 1];
        this.count = 0;
    }

    /**
     * 元素个数
     *
     * @return int
     * @apiNote 获取队列中元素个数
     * @since 2022/9/3 17:15
     */
    public int size() {
        return count;
    }

    /**
     * 队列为空
     *
     * @return boolean
     * @apiNote 判断队列是否为空 是返回true反之返回false
     * @since 2022/9/3 17:16
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 判断堆中索引i处是否小于j处
     *
     * @param i 索引i
     * @param j 索引j
     * @return boolean
     * @apiNote 小于返回true反之为false
     * @since 2022/9/3 17:19
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中值
     *
     * @param i 索引i
     * @param j 索引j
     * @apiNote 交换堆中索引i处和索引j处的值
     * @since 2022/9/3 17:21
     */
    private void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 插入元素
     *
     * @param t 插入的数据
     * @apiNote 向堆中插入数据
     * @since 2022/9/3 17:23
     */
    public void insert(T t) {
        // 将元素直接插入数组的最后
        items[++count] = t;
        // 使用上浮算法使该元素能在堆中处于一个合适的位置
        swim(count);
    }

    /**
     * 删除堆中最大的元素。并返回这个最大的元素
     *
     * @return T 最大的元素
     * @apiNote 堆中无元素时返回null
     * @since 2022/9/3 17:24
     */
    public T deleteMax() {
        // 记录堆中最大元素
        T maxItem = items[1];
        // 交换1位置处和最大索引处的元素
        exchange(1, count);
        // 减小长度
        count--;
        // 下沉现在处于1位置处的元素
        sink(1);
        return maxItem;
    }

    /**
     * 上浮索引元素
     *
     * @param index 索引
     * @apiNote (针对大元素)使用上浮算法将index索引处的元素能在堆中处于一个合适的位置
     * @since 2022/9/3 17:27
     */
    private void swim(int index) {
        // 当索引到达1处时终止且父节点元素小于子节点
        while (index > 1 && less(index / 2, index)) {
            exchange(index / 2, index);
            index = index / 2;
        }
    }


    /**
     * 下沉索引元素
     *
     * @param index 索引
     * @apiNote (针对小元素)使下沉浮算法将index索引处的元素能在堆中处于一个合适的位置
     * @since 2022/9/3 17:28
     */
    private void sink(int index) {
        // 左子节点索引应当小于最大长度
        int max;
        while (2 * index <= count) {
            // 获取左子节点和右子节点较大的那个索引
            if (2 * index + 1 <= count) {
                // 存在右子节点
                max = less(2 * index, 2 * index + 1) ? 2 * index + 1 : 2 * index;
            } else {
                // 不存在右子节点，默认左子节点最大
                max = 2 * index;
            }
            // 比较父节点与子节点
            if (less(index, max)) {
                // 如果父节点小于最大子节点则交换二者的位置
                exchange(index, max);
                // 变换索引
                index = max;
            } else {
                break;
            }
        }
    }
}
