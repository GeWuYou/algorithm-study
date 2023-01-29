package com.gewuyou.datastructures.priority;

/**
 * 最小优先队列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MinPriorityQueue
 * @apiNote 反转上浮和下沉算法，即堆为最小堆
 * @since 2022/9/5 7:47
 */
public class MinPriorityQueue<T extends Comparable<T>> {

    /**
     * 储存堆中元素
     */
    private T[] items;

    /**
     * 记录堆中要元素个数
     */
    private int count;

    public MinPriorityQueue(int capacity) {
        // ! 注意由于堆中不在0索引处存放值，所以新数组长度须加一，所以使用length时要注意减一长度
        this.items = (T[]) new Comparable[capacity + 1];
        this.count = 0;
    }

    /**
     * 元素个数
     *
     * @return int
     * @apiNote 获取队列中元素个数
     * @since 2022/9/5 7:55
     */
    public int size() {
        return count;
    }

    /**
     * 队列为空
     *
     * @return boolean
     * @apiNote 判断队列是否为空 是返回true反之返回false
     * @since 2022/9/5 7:55
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
     * @since 2022/9/5 7:56
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
     * @since 2022/9/5 7:57
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
     * @since 2022/9/5 7:58
     */
    public void insert(T t) {
        items[++count] = t;
        // 使用上浮算法进行堆调整
        swim(count);
    }


    /**
     * 删除堆中最小的元素。并返回这个最小的元素
     *
     * @return T 最小的元素
     * @apiNote 堆中无元素时返回null
     * @since 2022/9/5 7:59
     */
    public T deleteMin() {
        // 记录堆中最小元素
        T minItem = items[1];
        // 交换1位置处和最大索引处的元素
        exchange(1, count);
        // 减小长度
        count--;
        // 下沉现在处于1位置处的元素
        sink(1);
        return minItem;
    }


    /**
     * 上浮索引元素
     *
     * @param index 索引index
     * @apiNote (针对小元素)使用上浮算法将index索引处的元素能在堆中处于一个合适的位置
     * @since 2022/9/5 7:59
     */
    private void swim(int index) {
        // 当索引大于1且父节点元素大于子节点继续循环
        while (index > 1 && less(index, index / 2)) {
            // 当父节点大于子节点时，交换二者位置完成上浮
            exchange(index / 2, index);
            // 索引++
            index = index / 2;
        }
    }


    /**
     * 下沉索引元素
     *
     * @param index 索引
     * @apiNote (针对大元素)使下沉浮算法将index索引处的元素能在堆中处于一个合适的位置
     * @since 2022/9/5 7:59
     */
    private void sink(int index) {
        // 左子节点索引应当小于最大长度
        int min;
        while (2 * index <= count) {
            // 获取左子节点和右子节点较小的那个索引
            if (2 * index + 1 <= count) {
                // 存在右子节点
                min = less(2 * index, 2 * index + 1) ? 2 * index : 2 * index + 1;
            } else {
                // 不存在右子节点，默认左子节点最小
                min = 2 * index;
            }
            // 比较父节点与子节点
            if (less(min, index)) {
                // 如果父节点大于最小子节点则交换二者的位置
                exchange(index, min);
                // 变换索引
                index = min;
            } else {
                break;
            }
        }
    }
}
