package com.gewuyou.datastructures.priority;

/**
 * 索引最小优先队列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName IndexMinPriorityQueue
 * @apiNote 索引最小优先队列
 * @since 2022/9/5 10:49
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {

    /**
     * 储存堆中的元素
     */
    private T[] items;

    /**
     * pq数组 (堆)
     *
     * @apiNote 保存每个元素在items数组中的索引，该数组需要堆有序
     */
    private int[] pq;

    /**
     * qp数组
     *
     * @apiNote 保存qp的逆序，pq的值作为索引，pq的索引作为值
     */
    private int[] qp;

    /**
     * 记录堆中要元素个数
     */
    private int count;

    public IndexMinPriorityQueue(int capacity) {
        // ! 注意由于堆中不在0索引处存放值，所以新数组长度须加一，所以使用length时要注意减一长度
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.count = 0;
        // ? 默认情况下队列中没有存储任何数据 让qp中的元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    /**
     * 元素个数
     *
     * @return int
     * @apiNote 获取队列中元素个数
     * @since 2022/9/5 10:58
     */
    public int size() {
        return count;
    }

    /**
     * 队列为空
     *
     * @return boolean
     * @apiNote 判断队列是否为空 是返回true反之返回false
     * @since 2022/9/5 10:59
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
     * @since 2022/9/5 10:59
     */

    private boolean less(int i, int j) {
        // 通过pq访问items中的数据进行比较
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    /**
     * 交换堆中值
     *
     * @param i 索引i
     * @param j 索引j
     * @apiNote 交换堆中索引i处和索引j处的值
     * @since 2022/9/5 11:00
     */

    private void exchange(int i, int j) {
        // 交换pq中的数据
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        // 更新qp中的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 是否存在对应元素
     *
     * @param index 索引
     * @return boolean
     * @apiNote 判断堆中index索引处的元素是否存在
     * @since 2022/9/5 11:07
     */
    public boolean contains(int index) {
        return qp[index] != -1;
    }

    /**
     * 最小元素关联的索引
     *
     * @return int
     * @apiNote 返回最小元素关联的索引
     * @since 2022/9/5 11:09
     */
    public int minIndex() {
        return pq[1];
    }

    /**
     * 插入元素
     *
     * @param index 关联索引
     * @param t     插入的数据
     * @apiNote 向堆中插入数据并关联索引index
     * @since 2022/9/5 7:58
     */
    public void insert(int index, T t) {
        // 判断index是否被关联，如果已经被关联则不让插入
        if (contains(index)) {
            return;
        }
        // 元素个数自增
        count++;
        // 把数据存储到items对应的index位置处
        items[index] = t;
        // 把index储存到pq中
        pq[count] = index;
        // 通过qp来记录pq中的index
        qp[index] = count;
        // 通过上浮完成堆的调整 调整最后一个元素
        swim(count);
    }


    /**
     * 删除堆中最小的元素。并返回这个最小的元素关联的索引
     *
     * @return T 最小的元素
     * @apiNote 堆中无元素时返回null
     * @since 2022/9/5 7:59
     */
    public int deleteMin() {
        // 获取最小元素
        int minIndex = pq[1];
        // 交换pq中1位置的索引与最大索引处的索引
        exchange(1, count);
        // 删除qp对应的内容
        qp[pq[count]] = -1;
        // 删除pq[count]对应的内容
        pq[count] = -1;
        // 删除items中的内容
        items[minIndex] = null;
        // 让元素个数减一
        count--;
        // 对堆进行下沉调整
        sink(1);
        return minIndex;
    }

    /**
     * 删除index处关联的元素
     *
     * @param index 关联索引
     * @apiNote
     * @since 2022/9/5 11:13
     */
    public void delete(int index) {
        // 找到index在pq中的索引 （找出items中数据映射在pq中的索引）
        int pqIndex = qp[index];
        // 交换pq索引pqIndex处的值和索引count处的值 (操作映射数组pq，交换关联索引index映射与pq中的索引与pq中最大索引处的位置)
        exchange(pqIndex, count);
        // 删除qp中的内容 (删除逆序表中数据)
        qp[pq[count]] = -1;
        // 删除pq中的内容
        pq[count] = -1;
        // 删除items 中的内容
        items[pqIndex] = null;
        // 元素数量减一
        count--;
        //  堆调整
        swim(count);
        sink(count);
    }

    /**
     * 把与index关联的元素修改为t
     *
     * @param index 关联索引
     * @param t     数据
     * @apiNote
     * @since 2022/9/5 11:15
     */
    public void changeItem(int index, T t) {
        // 修改items数组中index位置的数据
        items[index] = t;
        // 找到index在pq中的位置
        int pqIndex = qp[index];
        // 堆调整
        swim(pqIndex);
        sink(pqIndex);
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
