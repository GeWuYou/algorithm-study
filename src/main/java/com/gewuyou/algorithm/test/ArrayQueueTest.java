package com.gewuyou.algorithm.test;

import com.gewuyou.datastructures.linear.ArrayQueue;

/**
 * 队列测试
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ArrayQueueTest
 * @apiNote 队列测试方法
 * @since 2022/9/14 14:49
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        //创建队列对象
        ArrayQueue<String> q= new ArrayQueue<>(3);

        //测试队列的add方法
        q.add("a");
        q.add("b");
        q.add("c");
        q.remove();
        q.add("d");
        q.add("d");
        q.remove();
        q.add("d");

        q.show();
        System.out.println("-------------------------------");
        //测试队列的dequeue方法
        String result = q.remove();
        System.out.println("出队列的元素是："+result);
        System.out.println("剩余的元素个数："+q.size());

    }
}
