package com.gewuyou.datastructures.linear;

/**
 * 队列(基于数组)
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ArrayQueue
 * @apiNote 队列(基于数组) <p>缺点：在队列出队时需要搬数据填补空缺在队列非常长的情况下浪费性能</p>
 * @since 2022/9/14 13:59
 */
public class ArrayQueue<T> {
    /**
     * 数组容量
     */
    private int capacity;
    /**
     * 队列头
     */
    private int queueHead;
    /**
     * 队列尾
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
     * @return null
     * @apiNote
     * @since 2022/9/14 14:23
     */
    public ArrayQueue(int capacity) {
        // 初始化容量
        this.capacity = capacity;
        // 初始化数组 0索引不存储数据
        array = (T[]) new Object[capacity + 1];
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     * @apiNote 是返回true, 否返回false
     * @since 2022/9/14 14:14
     */
    public boolean isEmpty() {
        return queueHead == queueTail;
    }

    /**
     * 入队
     *
     * @param item 数据
     * @return boolean 插入结果
     * @apiNote 向队列中插入一个元素
     * @since 2022/9/14 14:16
     */
    public boolean add(T item) {
        // 1、移动队列尾
        queueTail++;
        // 2、检查是否超出最大索引或者是否为空
        if (isEmpty() || queueTail > capacity) {
            queueTail--;
            return false;
        }
        // 3、向数组添加数据
        array[queueTail] = item;
        // 4、返回结果
        return true;
    }

    /**
     * 出队
     *
     * @return T 出队元素
     * @apiNote 从队列中拿出一个元素
     * @since 2022/9/14 14:20
     */
    public T remove() {
        // 1、检查当前队列是否为空
        if (isEmpty()) {
            return null;
        }
        // 2、不操作数组。记录队列头，让首位元素出队
        T removeItem = array[queueHead + 1];
        // 3、队列尾前移
        queueTail--;
        // 4、将所有元素前移
        for (int i = 1;i<=queueTail; i++) {
            array[i] = array[i + 1];
        }

        return removeItem;
    }

    /**
     * 元素的个数
     *
     * @return int
     * @apiNote 获取队列中元素的个数
     * @since 2022/9/14 14:21
     */
    public int size() {
        return queueTail;
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
     * 打印队列
     *
     * @apiNote
     * @since 2022/9/14 14:56
     */
    public void show() {
        if (!isEmpty()) {
            for (int i = 0; i < queueTail; i++) {
                System.out.println(array[i + 1]);
            }
        }
    }

}
