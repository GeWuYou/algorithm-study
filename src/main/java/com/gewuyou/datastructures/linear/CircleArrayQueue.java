package com.gewuyou.datastructures.linear;

/**
 * 环形队列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CircleArrayQueue
 * @apiNote 环形队列(基于数组)
 * @since 2022/9/14 15:49
 */
public class CircleArrayQueue<T> {
    /**
     * 数组容量
     */
    private int capacity;
    /**
     * 队列头 指向队列中的第一个元素
     */
    private int queueHead;
    /**
     * 队列尾 指向队列最后一个元素的最后一个位置
     */
    private int queueTail;
    /**
     * 数据数组
     */
    private T[] array;


    /**
     * 初始化队列
     *
     * @param capacity 队列容量
     * @apiNote
     * @since 2022/9/14 14:23
     */
    public CircleArrayQueue(int capacity) {
        // 初始化容量
        this.capacity = capacity + 1;
        // 初始化数组 0索引存储数据
        array = (T[]) new Object[capacity + 1];
    }


    /**
     * 判断队列是否为空
     *
     * @return boolean
     * @apiNote 是返回true, 否返回false
     * @since 2022/9/14 18:13
     */
    public boolean isEmpty() {
        return queueHead == queueTail;
    }

    /**
     * 判断队列是否已满
     *
     * @return boolean
     * @apiNote 是返回true, 否返回false
     * @since 2022/9/14 18:16
     */

    public boolean isFull() {
        return (queueTail + 1) % capacity == queueHead;
    }

    /**
     * 元素的个数
     *
     * @return int
     * @apiNote 获取队列中元素的个数
     * @since 2022/9/14 14:21
     */
    public int size() {
        return (queueTail + capacity - queueHead) % capacity;
    }

    /**
     * 队列容量
     *
     * @return int
     * @apiNote 获取队列容量
     * @since 2022/9/14 14:23
     */
    public int capacity() {
        return capacity;
    }

    /**
     * 入队
     *
     * @param item 数据
     * @return boolean 是否成功
     * @apiNote 添加数据到队列
     * @since 2022/9/14 21:28
     */
    public boolean add(T item) {
        // 判断队列是否满
        if (isFull()) {
            return false;
        }
        // 直接将数据加入并移动队列尾
        array[queueTail] = item;
        //移动时需要考虑取模 防止队列尾无线增长
        queueTail = (++queueTail) % capacity;
        return true;
    }

    /**
     * 出队
     *
     * @return T
     * @apiNote 将第一个添加的数据移出队列
     * @since 2022/9/14 21:36
     */
    public T remove() {
        // 判断队列是否为空
        if (isEmpty()) {
            return null;
        }
        // 这里需要分析queueHead是指向队列的第一个元素
        // 1、先把queueHead对应的值保存到临时变量
        T temp = array[queueHead];
        // 2、将queueHead后移 需要考虑取模
        queueHead = (++queueHead) % capacity;
        // 3、将临时保存的变量返回
        return temp;
    }

    /**
     * 打印队列
     *
     * @apiNote
     * @since 2022/9/14 14:56
     */
    public void show() {
        if (!isEmpty()) {
            for (int i = queueHead; i < queueHead + size(); i++) {
                System.out.println(array[i]);
            }
        }
    }

}
